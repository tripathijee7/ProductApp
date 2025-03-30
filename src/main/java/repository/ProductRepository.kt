package com.example.productapp.repository

import com.example.productapp.data.ApiService
import com.example.productapp.data.RetrofitClient
import com.example.productapp.data.model.Product

class ProductRepository(
    private val apiService: ApiService = RetrofitClient.createService(ApiService::class.java)
) {
    suspend fun getProducts(): List<Product> {
        return try {
            apiService.getProducts().products
        } catch (e: Exception) {
            emptyList()
        }
    }
}