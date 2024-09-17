package com.example.composemultimodulmvvm.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composemultimodulmvvm.screen.AppMainScreen
import com.example.composemultimodulmvvm.ui.theme.ComposeMultiModulMvvmTheme
import com.example.doogs_datasource.data.remote.model.DogResponse
import com.example.composemultimodulmvvm.screen.DogImageCard
import com.example.composemultimodulmvvm.screen.LoadingIndicator
import com.example.composemultimodulmvvm.state.DogState
import com.example.composemultimodulmvvm.viewmodel.DogsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: DogsViewModel by viewModels()

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMultiModulMvvmTheme {
                AppMainScreen(context = this)
                DogScreen(viewModel)
            }
        }
    }
}


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DogScreen(viewModel: DogsViewModel) {
    when (val state = viewModel.dogState) {
        is DogState.Loading -> {
            LoadingIndicator()
        }

        is DogState.Success -> {
            LazyGridImageList(state.dogs)
        }

        is DogState.Error -> {
            Text(text = state.message, color = Color.Red)
        }
    }
}

@Composable
fun LazyGridImageList(dogResponses: List<DogResponse>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 130.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(dogResponses) { dogResponse ->
            DogImageCard(dogResponse.message, dogResponse.status)
        }
    }
}


