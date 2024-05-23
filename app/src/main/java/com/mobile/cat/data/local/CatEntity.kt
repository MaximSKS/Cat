package com.mobile.cat.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatEntity(
    @PrimaryKey(autoGenerate = true)
    val catId: Int? = null,
    val image: String,
    val breedName: String,
)
