package com.example.composemultimodulmvvm.state

import com.example.doogs_datasource.data.remote.model.DogResponse

sealed class DogState {
    object Loading : DogState()
    data class Success(val dogs: List<DogResponse>) : DogState()
    data class Error(val message: String) : DogState()
}