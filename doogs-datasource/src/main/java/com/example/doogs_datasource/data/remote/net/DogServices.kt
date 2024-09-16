package com.example.doogs_datasource.data.remote.net

import com.example.doogs_datasource.data.remote.model.DogsResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogServices {
    @GET("breeds/image/random/50")
    suspend fun getRandomDogs(): Response<DogsResponse>
}