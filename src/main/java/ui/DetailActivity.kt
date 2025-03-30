package com.example.productapp.ui

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.productapp.R
import com.example.productapp.data.model.Product
import com.example.productapp.ui.adapter.ImageSliderAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getParcelableExtra<Product>("product")!!

        findViewById<TextView>(R.id.tvTitle).text = product.title
        findViewById<TextView>(R.id.tvPrice).text = "$${product.price}"
        findViewById<RatingBar>(R.id.ratingBar).rating = product.rating.toFloat()
        findViewById<TextView>(R.id.tvDescription).text = product.description

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ImageSliderAdapter(product.images)

        TabLayoutMediator(
            findViewById(R.id.tabDots),
            viewPager
        ) { _, _ -> }.attach()
    }
}