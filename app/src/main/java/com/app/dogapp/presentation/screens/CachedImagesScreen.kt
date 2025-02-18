package com.app.dogapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
            .padding(start = 16.dp, end = 16.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow (
            modifier = Modifier.fillMaxWidth()
                .padding(top = 80.dp),
            state = rememberLazyListState()
        ) {
            items(cachedImages.reversed()) { url ->
                AsyncImage(
                    model = url,
                    contentDescription = "Cached Dog Image",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(4.dp),
                    contentScale = ContentScale.Fit

                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.clearCache() },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = button_color)),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text("Clear Dogs", color = Color.White)
        }
    }
}