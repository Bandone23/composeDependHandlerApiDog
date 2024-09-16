package com.example.doogs_datasource.data.remote.source

import com.example.doogs_datasource.data.remote.net.DogServices
import com.example.doogs_datasource.data.services.RetrofitClient

class DogsDataSource( private val apiService: DogServices = RetrofitClient.dogService) {

    suspend fun getRandomDogs() = apiService.getRandomDogs()

}