package com.example.androiddevelopment.compose_about_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevelopment.R

@Composable
fun ComposeAboutApp() {
    Box(modifier = Modifier.fillMaxSize()) {


        // LazyColumn{
        //  item {
        //          ...
        //       }
        //  }
        //
        //  is similar to
        //
        //  ListView(
        //      children: [
        //                ...
        //                ]
        //          )
        //
        //          in flutter

        LazyColumn {
            item {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)) {
                    ComposeImage()
                }
                Box(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.lone_first_string),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Box(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.second_long_text),
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Composable
fun ComposeImage() {
    return Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}