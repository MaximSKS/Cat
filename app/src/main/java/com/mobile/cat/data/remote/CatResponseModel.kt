package com.mobile.cat.data.remote

//data class CatResponseModel(
//    val id: String,
//    val imageId: String, // reference_image_id
//    val name: String,
//    val breed: String,
//    val weight: String,
//    val temperament: String,
//    val origin: String,
//    val lifeSpan: String,   // life_span
//    val childFriendly: Int,  // child_friendly
//    val dogFriendly: Int,  // dog_friendly
//    val energyLevel: Int,  // energy_level
//    val intelligence: Int,
//    val description: String,
//    val wikipediaUrl: String,  // wikipedia_url
//
//)

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
    val life_span: String,
    val child_friendly: Int,
    val dog_friendly: Int,
    val energy_level: Int,
    val intelligence: Int,
    val description: String,
    val wikipedia_url: String
)

data class Weight(
    val imperial: String,
    val metric: String
)


/**
 *     "weight": {
 *       "imperial": "8 - 20",
 *       "metric": "4 - 9"
 *     },
 *     "id": "raga",
 *     "name": "Ragamuffin",
 *     "cfa_url": "http://cfa.org/Breeds/BreedsKthruR/Ragamuffin.aspx",
 *     "vetstreet_url": "http://www.vetstreet.com/cats/ragamuffin",
 *     "vcahospitals_url": "https://vcahospitals.com/know-your-pet/cat-breeds/ragamuffin",
 *     "temperament": "Affectionate, Friendly, Gentle, Calm",
 *     "origin": "United States",
 *     "country_codes": "US",
 *     "country_code": "US",
 *     "description": "The Ragamuffin is calm, even tempered and gets along well with all family members. Changes in routine generally do not upset her. She is an ideal companion for those in apartments, and with children due to her patient nature.",
 *     "life_span": "12 - 16",
 *     "indoor": 0,
 *     "lap": 1,
 *     "alt_names": "",
 *     "adaptability": 5,
 *     "affection_level": 5,
 *     "child_friendly": 4,
 *     "dog_friendly": 5,
 *     "energy_level": 3,
 *     "grooming": 3,
 *     "health_issues": 3,
 *     "intelligence": 5,
 *     "shedding_level": 3,
 *     "social_needs": 3,
 *     "stranger_friendly": 5,
 *     "vocalisation": 1,
 *     "experimental": 0,
 *     "hairless": 0,
 *     "natural": 0,
 *     "rare": 0,
 *     "rex": 0,
 *     "suppressed_tail": 0,
 *     "short_legs": 0,
 *     "wikipedia_url": "https://en.wikipedia.org/wiki/Ragamuffin_cat",
 *     "hypoallergenic": 0,
 *     "reference_image_id": "SMuZx-bFM"
 * */