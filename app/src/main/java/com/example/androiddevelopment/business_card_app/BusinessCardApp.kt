package com.example.androiddevelopment.business_card_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevelopment.R
import com.example.androiddevelopment.ui.theme.Purple80
import com.example.androiddevelopment.ui.theme.greenAccent

@Composable
fun BusinessCardApp() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = greenAccent)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .weight(1f) // when you put weight(1f) it's similar to Flutter's Expanded
                    .padding(10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .background(color = Color.Black)
                    ) {
                        AndroidImagePng()
                    }
                    Box(modifier = Modifier.height(10.dp))
                    Text(text = "Jennifer Doe", color = Color.Black, textAlign = TextAlign.Center)
                    Box(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Android Developer Extraordinaire",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Column() {
                    Row {
                        Icon(Icons.Rounded.Phone, contentDescription = null, tint = Color.Black)
                        Box(modifier = Modifier.width(10.dp))
                        Text(
                            text = "-111 012 345 678",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp
                        )
                    }
                    Box(modifier = Modifier.height(10.dp))
                    Row {
                        Icon(Icons.Rounded.Share, contentDescription = null, tint = Color.Black)
                        Box(modifier = Modifier.width(10.dp))
                        Text(
                            text = "@Android Dev",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp
                        )
                    }
                    Box(modifier = Modifier.height(10.dp))
                    Row {
                        Icon(Icons.Rounded.Email, contentDescription = null, tint = Color.Black)
                        Box(modifier = Modifier.width(10.dp))
                        Text(
                            text = "dev@gmail.com",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp
                        )
                    }
                    Box(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
private fun AndroidImagePng() {
    Image(
        painter = painterResource(id = R.drawable.android_logo),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}