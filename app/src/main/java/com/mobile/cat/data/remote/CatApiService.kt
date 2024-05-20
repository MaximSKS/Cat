package com.mobile.cat.data.remote

import com.mobile.cat.data.remote.CatRetrofitInstance.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatApiService {

    @GET("images/search")
    suspend fun getCatImages(
        @Query("limit") limit: Int = 100,
        @Query("has_breeds") hasBreeds: Int = 1,
        @Header("x-api-key") apiKey: String = API_KEY

    ): Response<List<CatImageResponse>>

}