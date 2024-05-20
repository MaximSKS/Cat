package com.mobile.cat.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatRetrofitInstance {

    private const val BASE_URL = "https://api.thecatapi.com/v1/"

    val API_KEY = "live_W4HtIzelnEy8Z3Xew2xdjv6wTEBxLng54wV56NDQwLYbY4Zkkfa9vtzUepxC9Z0i"

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