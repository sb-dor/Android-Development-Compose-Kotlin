package com.example.androiddevelopment.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@Composable
fun FirstNavigationComposable(
    paddingValues: PaddingValues,
    navigationController: NavHostController
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "First screen", textAlign = TextAlign.Center, color = Color.White)
            ElevatedButton(onClick = {

                navigationController.navigate(Screens.SecondScreen.name + "/Avaz")


            }) {
                Text(text = "Go Forward")
            }
        }
    }
}