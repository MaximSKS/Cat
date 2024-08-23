package com.mobile.cat.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCat::class], version = 1)
abstract class CatDatabase : RoomDatabase() {
    abstract fun favoriteCatDao(): FavoriteCatDao
}