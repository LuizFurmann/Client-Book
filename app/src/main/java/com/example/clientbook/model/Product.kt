package com.example.clientbook.model

import com.google.gson.annotations.SerializedName

data class Product(
//    @SerializedName("productId")
    val productId: String,
    val name: String,
    val details: String,
    val type: String,
    val price: Double,
    val favorite: Boolean,
)
