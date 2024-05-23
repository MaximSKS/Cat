package com.mobile.cat.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val catApiService: CatApiService by lazy {
        retrofit.create(CatApiService::class.java)
    }
}