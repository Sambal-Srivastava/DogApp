package com.app.dogapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.app.dogapp.R.color.button_color
import com.app.dogapp.presentation.viewmodel.DogViewModel

@Composable
fun CachedImagesScreen(navController: NavController, viewModel: DogViewModel = hiltViewModel()) {
    viewModel.loadCachedImages()
    val cachedImages by viewModel.cachedImages.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyRow {
            items(cachedImages) { url ->
                AsyncImage(
                    model = url,
                    contentDescription = "Cached Dog Image",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.clearCache() },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = button_color))
        ) {
            Text("Clear Dogs", color = Color.White)
        }
    }
}