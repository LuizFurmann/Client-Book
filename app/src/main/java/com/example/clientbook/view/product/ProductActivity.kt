package com.example.clientbook.view.product

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityClientBinding

class ProductActivity : AppCompatActivity() {

    private lateinit var binding : ActivityClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityClientBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()
        clickEvents()
    }

    private fun clickEvents(){
        binding.fabNewClient.setOnClickListener {
            addNewClient()
        }
    }

    private fun addNewClient(){
        Intent(this@ProductActivity, CreateProductActivity::class.java).also{
            startActivity(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setupToolbar() {
        title = "Dados do cliente"
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }
}