package com.example.clientbook.model

import com.google.gson.annotations.SerializedName

data class Product(
//    @SerializedName("productId")
    var productId: String,
    var name: String,
    var details: String,
    var type: String,
    var price: Double,
    var favorite: Boolean,
)
