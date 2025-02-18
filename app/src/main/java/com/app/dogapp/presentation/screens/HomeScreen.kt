package com.app.dogapp.presentation.screens

import android.content.res.Resources
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.dogapp.R
import com.app.dogapp.R.color.button_color
import com.app.dogapp.presentation.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.app_header_title))
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate(Screen.GenerateDogs) },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = button_color)),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text("Generate Dogs!", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate(Screen.CachedImages) },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = button_color)),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text("My Recently Generated Dogs!", color = Color.White)
            }
        }
    }
}