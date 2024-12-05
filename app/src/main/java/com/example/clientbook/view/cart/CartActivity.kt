package com.example.clientbook.view.cart

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityCartBinding
import com.example.clientbook.model.Product
import java.util.UUID

class CartActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCartBinding
    private val bestSaleAdapter = ProductCartAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerview()
        setupEventClick()

    }

    fun setupEventClick(){
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.arrowButton.setOnClickListener { view ->
            if (binding.hiddenView.getVisibility() === View.VISIBLE) {
                TransitionManager.beginDelayedTransition(binding.baseCardview, AutoTransition())
                binding.hiddenView.setVisibility(View.GONE)
                binding.arrowButton.setImageResource(R.drawable.ic_down)
            } else {
                TransitionManager.beginDelayedTransition(binding.baseCardview, AutoTransition())
                binding.hiddenView.setVisibility(View.VISIBLE)
                binding.arrowButton.setImageResource(com.example.clientbook.R.drawable.ic_up)
            }
        }
    }

    fun setupRecyclerview(){
        val productList = arrayListOf(
            Product(
                UUID.randomUUID().toString(),
                "Produto 1",
                "Detalhes do produto",
                "Tipo A",
                100.00,
                true
            ),
            Product(
                UUID.randomUUID().toString(),
                "Produto 2",
                "Detalhes do produto",
                "Tipo B",
                70.00,
                false
            ),
            Product(
                UUID.randomUUID().toString(),
                "Produto 3",
                "Detalhes do produto",
                "Tipo 5",
                150.00,
                true
            ),

            )

        val layoutManager = LinearLayoutManager(this)
        binding.rvProducts.layoutManager = layoutManager;
        binding.rvProducts.adapter = bestSaleAdapter
        binding.rvProducts.setHasFixedSize(true)

        updateList(productList)
    }

    private fun updateList(productList: List<Product>) {
        if (productList.isEmpty()) {

//            binding.rvExercise.visibility = View.GONE
//            binding.myExercisesTittle.visibility = View.GONE
//            binding.emptyExerciseList.visibility = View.VISIBLE
        } else {

            bestSaleAdapter.updateList(productList)
        }
    }
}