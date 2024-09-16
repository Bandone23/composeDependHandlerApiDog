package com.example.composemultimodulmvvm.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center) // Centra el indicador
        )
    }
}