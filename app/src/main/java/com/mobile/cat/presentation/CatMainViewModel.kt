package com.mobile.cat.presentation

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.mobile.cat.data.local.CatDatabase
import com.mobile.cat.data.local.FavoriteCat
import com.mobile.cat.data.remote.CatBreed
import com.mobile.cat.data.remote.CatImageResponse
import com.mobile.cat.data.remote.CatRetrofitInstance
import com.mobile.cat.navigation.CatRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatMainViewModel(application: Application) : AndroidViewModel(application) {

    private val database: CatDatabase = Room.databaseBuilder(
        application,
        CatDatabase::class.java,
        "cat_database"
    ).build()

    private val favoriteCatDao = database.favoriteCatDao()

    private val _catImagesMutableState = MutableStateFlow<List<CatImageResponse>>(emptyList())

    private val _breedsMutableState = MutableStateFlow<List<CatBreed>>(emptyList())
    val breedsState: StateFlow<List<CatBreed>> = _breedsMutableState

    private val _filteredCatImagesState = MutableStateFlow<List<CatImageResponse>>(emptyList())
    val filteredCatImagesState: StateFlow<List<CatImageResponse>> = _filteredCatImagesState
    private val _favoritesMutableState = MutableStateFlow<List<FavoriteCat>>(emptyList())
    val favoritesState: StateFlow<List<FavoriteCat>> = _favoritesMutableState

    init {
        fetchCatImages()
        fetchBreeds()
        fetchFavorites()
    }

    private fun fetchFavorites() {
        viewModelScope.launch {
            _favoritesMutableState.value = favoriteCatDao.getAllFavorites()
        }
    }

    fun addToFavorites(catImage: CatImageResponse) {
        val breed = catImage.breeds.firstOrNull() ?: return
        val favoriteCat = FavoriteCat(
            id = catImage.id,
            name = breed.name,
            imageUrl = catImage.url,
            breed = breed.name,
            weight = breed.weight.metric,
            lifeSpan = breed.lifeSpan,
            origin = breed.origin,
            temperament = breed.temperament,
            description = breed.description,
            wikipediaUrl = breed.wikipediaUrl
        )
        viewModelScope.launch {
            favoriteCatDao.insert(favoriteCat)
            fetchFavorites()
        }
    }

    fun removeFromFavorites(cat: FavoriteCat) {
        viewModelScope.launch {
            favoriteCatDao.delete(cat)
            fetchFavorites()
        }
    }

    //getting cat image and breed name for card
    private fun fetchCatImages() {
        viewModelScope.launch {
            try {
                val response = CatRetrofitInstance.catApiService.getCatImages()
                if (response.isSuccessful) {
                    response.body()?.let {
                        val uniqueBreedImages =
                            it.groupBy { catImage -> catImage.breeds.firstOrNull()?.id }
                                .values
                                .mapNotNull { breedImages -> breedImages.firstOrNull() }
                        _catImagesMutableState.value = uniqueBreedImages
                        _filteredCatImagesState.value = uniqueBreedImages
                    } ?: run {
                        _catImagesMutableState.value = emptyList()
                        _filteredCatImagesState.value = emptyList()
                    }
                } else {
                    _catImagesMutableState.value = emptyList()
                    _filteredCatImagesState.value = emptyList()
                }
            } catch (e: Exception) {
                _catImagesMutableState.value = emptyList()
                _filteredCatImagesState.value = emptyList()
            }
        }
    }

    // get all breed names list in search bar
    private fun fetchBreeds() {
        viewModelScope.launch {
            try {
                val response = CatRetrofitInstance.catApiService.getBreeds()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _breedsMutableState.value = it
                    } ?: run {
                        _breedsMutableState.value = emptyList()
                    }
                } else {
                    _breedsMutableState.value = emptyList()
                }
            } catch (e: Exception) {
                _breedsMutableState.value = emptyList()
            }
        }
    }

    // to filter cat cards by input breed
    fun filterCatImagesByBreed(breedId: String) {
        val filteredImages = _catImagesMutableState.value.filter { catImage ->
            val breed = catImage.breeds.firstOrNull()
            breed != null && breed.name.contains(breedId, ignoreCase = true)
        }
        _filteredCatImagesState.value = filteredImages

    }

    // to display detail info for clicked cat card
    fun getCatDetailsRoute(catImage: CatImageResponse): String {
        val breed = catImage.breeds.firstOrNull()
        val encodedCatImage = Uri.encode(catImage.url)
        val encodedBreedName = Uri.encode(breed?.name ?: "Unknown")
        val encodedWeight = Uri.encode(breed?.weight?.metric ?: "Unknown")
        val encodedLifeSpan = Uri.encode(breed?.lifeSpan ?: "Unknown")
        val encodedOrigin = Uri.encode(breed?.origin ?: "Unknown")
        val encodedTemperament = Uri.encode(breed?.temperament ?: "Unknown")
        val encodedDescription = Uri.encode(breed?.description ?: "Unknown")
        val encodedWikipediaUrl = Uri.encode(breed?.wikipediaUrl ?: "")

        return "${CatRoutes.DETAILS}" +
                "/$encodedCatImage" +
                "/$encodedBreedName" +
                "/$encodedWeight" +
                "/$encodedLifeSpan" +
                "/$encodedOrigin" +
                "/${breed?.adaptability ?: 0}" +
                "/${breed?.hypoallergenic ?: 0}" +
                "/$encodedTemperament" +
                "/${breed?.childFriendly ?: 0}" +
                "/${breed?.dogFriendly ?: 0}" +
                "/${breed?.strangerFriendly ?: 0}" +
                "/${breed?.sheddingLevel ?: 0}" +
                "/${breed?.affectionLevel ?: 0}" +
                "/${breed?.socialNeeds ?: 0}" +
                "/${breed?.energyLevel ?: 0}" +
                "/${breed?.intelligence ?: 0}" +
                "/$encodedDescription" +
                "/$encodedWikipediaUrl"
    }

}