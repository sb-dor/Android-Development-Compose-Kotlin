package com.example.androiddevelopment.app_architechture.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevelopment.R
import com.example.androiddevelopment.app_architechture.data.DataSource
import com.example.androiddevelopment.app_architechture.model.Dessert
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppArchitecture() {


    var listOfDessert = remember {
        mutableStateListOf<Dessert>()
    }

    val tempDessert = remember {
        mutableStateOf<Dessert?>(null);
    }

    fun addToList() {
        if (tempDessert.value == null) return;
        listOfDessert.add(tempDessert.value!!);
    }

    tempDessert.value = generateRandom();

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "App Architecture") }, colors = topAppBarColors(
                containerColor = Color.DarkGray
            )
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = { tempDessert.value = generateRandom() }) {
            Icon(Icons.Rounded.ArrowForward, contentDescription = "No DESC")
        }
    })

    { paddingValues ->
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(modifier = Modifier.padding(paddingValues)) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = tempDessert.value?.imageId ?: R.drawable.cupcake
                        ), contentDescription = null
                    )
                }
                Box(modifier = Modifier.height(10.dp))
                OutlinedButton(onClick = { addToList() }) {
                    Icon(Icons.Rounded.Add, contentDescription = null)
                }

                Box(modifier = Modifier.height(10.dp))

                Text(text = "Total: ${getTotal(listOfDessert.toList())}", color = Color.White)
            }
        }

    }
}


fun generateRandom(): Dessert {
    val random = Random.nextInt(0, DataSource.listOfDesserts.count());
    return DataSource.listOfDesserts[random];
}

fun getTotal(list: List<Dessert>): Int {
    var total: Int = 0;
    for (n in list) {
        total += n.price;
    }
    return total;
}