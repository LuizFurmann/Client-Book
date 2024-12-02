package com.example.clientbook.view.product

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onBtnFilterClick()
    }

    private fun onBtnFilterClick() {
        binding.includeBtns.btnP.setOnClickListener{
            val selectedFilter = "P"
            updateFilterIcons(selectedFilter)

        }
        binding.includeBtns.btnM.setOnClickListener{
            val selectedFilter = "M"
            updateFilterIcons(selectedFilter)


        }
        binding.includeBtns.btnG.setOnClickListener{
            val selectedFilter = "G"
            updateFilterIcons(selectedFilter)


        }
        binding.includeBtns.btnGG.setOnClickListener{
            val selectedFilter = "GG"
            updateFilterIcons(selectedFilter)


//            newExercise(selectedFilter)
        }
        binding.includeBtns.btnEG.setOnClickListener{
            val selectedFilter = "EG"
            updateFilterIcons(selectedFilter)

        }
    }

    private fun updateFilterIcons(newFilter: String) {
        updateBtnFilter(
            "P",
            newFilter,
            binding.includeBtns.btnP
        )
        updateBtnFilter(
            "M",
            newFilter,
            binding.includeBtns.btnM
        )
        updateBtnFilter(
            "G",
            newFilter,
            binding.includeBtns.btnG
        )
        updateBtnFilter(
            "GG",
            newFilter,
            binding.includeBtns.btnGG
        )
        updateBtnFilter(
            "EG",
            newFilter,
            binding.includeBtns.btnEG
        )
    }

    private fun updateBtnFilter(filter: String, filterSelect: String, button: TextView) {
        button.setTextColor(
            if (filter == filterSelect)
                ContextCompat.getColor(this, R.color.white)
            else
                ContextCompat.getColor(this, R.color.black)
        )

        button.background =
            if (filter == filterSelect) {
                ContextCompat.getDrawable(
                    this,
                    R.drawable.bg_btn_colorprimary_rounded
                )
            } else {
                ContextCompat.getDrawable(
                    this,
                    R.drawable.bg_btn_transparent_rounded
                )
            }
    }
}