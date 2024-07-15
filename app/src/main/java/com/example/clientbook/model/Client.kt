package com.example.clientbook.model

import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("fantasy_name") val fantasy_name: String,
)
