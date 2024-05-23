package com.mobile.cat.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CatEntity::class], version = 1)
abstract class CatMainDB: RoomDatabase() {

    abstract fun catDao(): CatDao
}