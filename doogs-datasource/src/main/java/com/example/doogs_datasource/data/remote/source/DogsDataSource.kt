package com.example.doogs_datasource.data.remote.source

import com.example.doogs_datasource.data.remote.net.DogServices
import javax.inject.Inject

class DogsDataSource @Inject constructor(private val apiService:DogServices) {

    suspend fun getRandomDogs() = apiService.getRandomDogs()

}