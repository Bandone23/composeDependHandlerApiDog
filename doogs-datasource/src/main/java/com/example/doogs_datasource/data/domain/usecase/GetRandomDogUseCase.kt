package com.example.doogs_datasource.data.domain.usecase

import com.example.doogs_datasource.data.repository.DogsRepository
import javax.inject.Inject

class GetRandomDogUseCase @Inject constructor(private val repository: DogsRepository) {
    suspend operator fun invoke() = repository.getRandomDogs()
}