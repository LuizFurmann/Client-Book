package com.example.clientbook.view.clients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityClientBinding

class ClientActivity : AppCompatActivity() {

    private lateinit var binding : ActivityClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityClientBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}