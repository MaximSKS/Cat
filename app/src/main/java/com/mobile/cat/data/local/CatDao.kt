package com.mobile.cat.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CatDao {

    @Query("SELECT * FROM CatEntity")
    fun getAllCats(): List<CatEntity>

    @Insert
    fun insertCat(cat: CatEntity)

    @Delete
    fun deleteCat(cat: CatEntity)


}