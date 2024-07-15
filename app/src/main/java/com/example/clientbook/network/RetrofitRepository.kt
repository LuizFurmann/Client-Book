package com.example.clientbook.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clientbook.model.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository {

    private val apiService = RetrofitUtil.apiService
    var client: MutableLiveData<List<Client>> = MutableLiveData<List<Client>>()

    fun getClient(): LiveData<List<Client>> {
        apiService.getClient().enqueue(object : Callback<List<Client>> {
            override fun onResponse(call: Call<List<Client>>, response: Response<List<Client>>) {
                if (response.isSuccessful) {
                    var teste : List<Client> = response.body()!!
                    client.postValue(teste)
                } else {
                    // Tratar erros de requisição aqui
                }
            }

            override fun onFailure(call: Call<List<Client>>, t: Throwable) {
                // Tratar falha na requisição aqui
            }
        })

        return client
    }
}