package com.mobile.cat.data.remote

import com.google.gson.annotations.SerializedName

data class CatImageResponse(
    val id: String,
    val url: String,
    val breeds: List<CatBreed>
)

data class CatBreed(
    val id: String,
    val name: String,
    val weight: Weight,
    val temperament: String,
    val origin: String,
    val adaptability: Int,
    val hypoallergenic: Int,
    val intelligence: Int,
    val description: String,
    @SerializedName("life_span") val lifeSpan: String,
    @SerializedName("child_friendly") val childFriendly: Int,
    @SerializedName("dog_friendly") val dogFriendly: Int,
    @SerializedName("stranger_friendly") val strangerFriendly: Int,
    @SerializedName("shedding_level") val sheddingLevel: Int,
    @SerializedName("affection_level") val affectionLevel: Int,
    @SerializedName("social_needs") val socialNeeds: Int,
    @SerializedName("energy_level") val energyLevel: Int,
    @SerializedName("wikipedia_url") val wikipediaUrl: String
)

data class Weight(
    val metric: String
)