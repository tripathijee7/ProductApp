package com.example.productapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.data.model.Product
import com.example.productapp.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    fun loadProducts(
        onSuccess: (List<Product>) -> Unit,
        onError: (Throwable) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                val products = repository.getProducts()
                onSuccess(products)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}