package com.example.doogs_datasource.data.services

import com.example.doogs_datasource.data.remote.net.DogServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private const val BASE_URL = "https://dog.ceo/api/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val dogService: DogServices = retrofit.create(DogServices::class.java)

}