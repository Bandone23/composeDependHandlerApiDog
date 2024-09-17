package com.example.composemultimodulmvvm.viewmodel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemultimodulmvvm.state.DogState
import com.example.doogs_datasource.data.domain.usecase.*
import com.example.doogs_datasource.data.remote.model.DogResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class DogsViewModel @Inject constructor(
    private val getRandomDogUseCase: GetRandomDogUseCase
) : ViewModel() {
    var dogState by mutableStateOf<DogState>(DogState.Loading)
        private set

    init {
        getRandomDogs()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getRandomDogs() {
        viewModelScope.launch {
            dogState = DogState.Loading
            try {
                val response = getRandomDogUseCase.invoke()

                if (response.isSuccessful) {
                    val dogsList =
                        response.body()?.message?.map { DogResponse(it, "") } ?: emptyList()
                    dogState = DogState.Success(dogsList)
                } else {
                    dogState = DogState.Error("Error al obtener los perros: ${response.code()}")
                }
            } catch (e: IOException) {
                dogState = DogState.Error("Error de red: ${e.localizedMessage}")
            } catch (e: HttpException) {
                dogState = DogState.Error("Error del servidor: ${e.localizedMessage}")
            } catch (e: Exception) {
                dogState = DogState.Error("Error inesperado: ${e.localizedMessage}")
            }
        }
    }
}
