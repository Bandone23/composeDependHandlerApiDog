package com.example.doogs_datasource.data.domain.usecase

import com.example.doogs_datasource.data.repository.DogsRepository

class GetRandomDogUseCase(private val repository: DogsRepository = DogsRepository())  {
    suspend operator fun invoke() = repository.getRandomDogs()
}