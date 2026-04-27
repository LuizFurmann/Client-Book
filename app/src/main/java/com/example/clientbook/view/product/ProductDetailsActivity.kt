package com.example.clientbook.view.product

import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityProductDetailsBinding
import com.example.clientbook.model.Product

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductDetailsBinding
    lateinit var product: Product
    private val REQUEST_IMAGE = 100
    private var profilePicturePath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.setPadding(
                0,
                bars.top,     // status bar
                0,
                bars.bottom   // navigation bar
            )
            insets
        }

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