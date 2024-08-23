package com.mobile.cat.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteCatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cat: FavoriteCat)

    @Delete
    suspend fun delete(cat: FavoriteCat)

    @Query("SELECT * FROM favorite_cats")
    suspend fun getAllFavorites(): List<FavoriteCat>
}