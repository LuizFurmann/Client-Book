package com.example.clientbook.network

import com.example.clientbook.model.Client
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("api/cliente")
    fun getClient(): Call<List<Client>>
}