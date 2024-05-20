package com.mobile.cat.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.cat.data.remote.CatImageResponse
import com.mobile.cat.data.remote.CatRetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatMainViewModel: ViewModel(){

    private val _catImagesMutableState = MutableStateFlow<List<CatImageResponse>>(emptyList())
    val catImagesState = _catImagesMutableState


    init {
        fetchCatImages()
    }

    private fun fetchCatImages() {
        viewModelScope.launch {
            try {
                val response = CatRetrofitInstance.catApiService.getCatImages()
                if (response.isSuccessful) {
                    response.body()?.let {
                        val uniqueBreedImages = it.groupBy { catImage -> catImage.breeds.firstOrNull()?.id }
                            .values
                            .mapNotNull { breedImages -> breedImages.firstOrNull() }
                        _catImagesMutableState.value = uniqueBreedImages
                        Log.d("CatMainViewModel", "Fetched cat images: $it")
                    } ?: run {
                        _catImagesMutableState.value = emptyList()
                        Log.e("CatMainViewModel", "Response body is null")
                    }
                } else {

                    Log.e("CatMainViewModel", "Failed to fetch cat images: ${response.errorBody()}")
                    _catImagesMutableState.value = emptyList()
                }
            } catch (e: Exception) {

                Log.e("CatMainViewModel", "Error fetching cat images", e)
                _catImagesMutableState.value = emptyList()
            }
        }
    }
}