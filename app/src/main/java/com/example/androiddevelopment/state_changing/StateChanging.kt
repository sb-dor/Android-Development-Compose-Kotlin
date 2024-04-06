package com.example.androiddevelopment.state_changing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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

@Composable
fun StateChangingComposable() {

    val counter = remember {
        mutableIntStateOf(0)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            ElevatedButton(onClick = { counter.intValue++ }) {
                Text(text = "Tap counter", color = Color.White)
            }
            Box(modifier = Modifier.height(10.dp))
            Text(text = "${counter.intValue}", fontSize = 20.sp, textAlign = TextAlign.Center)
        }
    }
}