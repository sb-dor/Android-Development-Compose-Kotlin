package com.example.androiddevelopment.happy_birthday_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevelopment.R

@Preview(showSystemUi = true, name = "My happy birthday ui")
@Composable
fun HappyBirthdayUi(message: String? = null, from: String? = null) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        ImageBackground(imagePath = R.drawable.androidparty, Modifier.fillMaxSize())

        // when you wrap Column or Row widget with Box widget, and when you want to set
        // "arrangement" parameter - it will not work in Column or in Row,
        // that is why you have to put "contentAlignment" in Box parameter
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                // start -> left
                // top -> top
                // end -> right
                // bottom -> bottom
                .padding(start = 10.dp, end = 10.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "${stringResource(R.string.happy_birthday)} $message",
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    lineHeight = 45.sp, // default is 32
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Box(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    text = "From ${from ?: "nobody"}",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun ImageBackground(imagePath: Int, modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = imagePath),
        contentScale = ContentScale.Crop,
        contentDescription = "no desc"
    )
}