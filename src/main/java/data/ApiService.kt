package com.example.productapp.data

import com.example.productapp.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }

    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 20
    ): ApiResponse
}