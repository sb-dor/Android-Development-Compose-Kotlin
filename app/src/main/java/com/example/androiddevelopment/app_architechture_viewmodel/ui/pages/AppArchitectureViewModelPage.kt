package com.example.androiddevelopment.app_architechture_viewmodel.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevelopment.R
import com.example.androiddevelopment.app_architechture_viewmodel.ui.view_model.AppArchitectureViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppArchitectureViewModelPage(viewModel: AppArchitectureViewModel = viewModel()) {


    val currentState by viewModel.uiState;

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = stringResource(R.string.app_architecture_viewmodel)) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.DarkGray
            )
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = { viewModel.generateRandom() }) {
            Icon(Icons.Rounded.ArrowForward, contentDescription = "No DESC")
        }
    })

    { paddingValues ->
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(
                            id = currentState.tempDessert?.imageId ?: R.drawable.cupcake
                        ), contentDescription = null
                    )
                }
                Box(modifier = Modifier.height(10.dp))
                Text(
                    text = "Price: ${currentState.tempDessert?.price ?: 0}",
                    color = Color.White
                )
                Box(modifier = Modifier.height(10.dp))
                OutlinedButton(onClick = { viewModel.addToList() }) {
                    Icon(Icons.Rounded.Add, contentDescription = null)
                }

                Box(modifier = Modifier.height(10.dp))

                Text(text = "Total: ${viewModel.getTotal()}", color = Color.White)
            }
        }

    }
}