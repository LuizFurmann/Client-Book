package com.example.clientbook.view.cart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}