package com.mobile.cat.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorite_cats")
data class FavoriteCat(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val breed: String,
    val weight: String,
    val lifeSpan: String,
    val origin: String,
    val temperament: String,
    val description: String,
    val wikipediaUrl: String?
)