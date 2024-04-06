package com.example.androiddevelopment.state_changing

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("MutableCollectionMutableState")
@Composable
fun StateChangingComposable() {

    val counter = remember {
        mutableIntStateOf(0)
    }

    val arrayOfData = remember {
        mutableStateListOf<String>()
    }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn {
            item {
                ElevatedButton(onClick = { counter.intValue++ }) {
                    Text(text = "Tap counter", color = Color.White)
                }
                Box(modifier = Modifier.height(10.dp))
                Text(text = "${counter.intValue}", fontSize = 20.sp, textAlign = TextAlign.Center)
                Box(modifier = Modifier.height(10.dp))

                Box(modifier = Modifier.height(10.dp))

                ElevatedButton(onClick = { arrayOfData.add("5") }) {
                    Text(text = "Tap counter", color = Color.White)
                }

                Box(modifier = Modifier.height(10.dp))
                Text(text = "${arrayOfData.toList()}", fontSize = 20.sp, textAlign = TextAlign.Center)
                Box(modifier = Modifier.height(10.dp))
            }

            items(arrayOfData) { item -> Text(text = "Item: $item") }

            itemsIndexed(arrayOfData) { item, index -> Text(text = "Item: $item | index: $index") }
        }
    }
}