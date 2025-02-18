package com.app.dogapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.app.dogapp.R
import com.app.dogapp.presentation.viewmodel.DogViewModel

@Composable
fun GenerateDogsScreen(navController: NavController, viewModel: DogViewModel = hiltViewModel()) {
    val imageUrl by viewModel.imageUrl.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        imageUrl?.let { url ->
            AsyncImage(
                model = url,
                contentDescription = "Random Dog Image",
                modifier = Modifier.size(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.fetchRandomDogImage() },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_color)),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text("Generate!", color = Color.White)
        }
    }
}