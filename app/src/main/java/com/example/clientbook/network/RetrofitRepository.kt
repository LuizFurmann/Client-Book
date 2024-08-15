package com.example.clientbook.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clientbook.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository {

    private val apiService = RetrofitUtil.apiService
    var client: MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()

    fun getClient(): LiveData<List<Product>> {
        apiService.getClient().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    var teste : List<Product> = response.body()!!
                    client.postValue(teste)
                } else {
                    // Tratar erros de requisição aqui
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Tratar falha na requisição aqui
            }
        })

        return client
    }
}