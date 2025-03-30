package com.example.productapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productapp.databinding.ActivityMainBinding
import com.example.productapp.data.model.Product
import com.example.productapp.repository.ProductRepository
import com.example.productapp.ui.adapter.ProductAdapter
import com.example.productapp.viewmodel.ProductViewModel
import com.example.productapp.viewmodel.ProductViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(ProductRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ProductAdapter { product ->
            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra("product", product)
            })  // Added missing parenthesis here
        }  // Added missing parenthesis here

        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }

        viewModel.loadProducts(
            onSuccess = { products ->
                adapter.submitList(products)
            },
            onError = { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }
}