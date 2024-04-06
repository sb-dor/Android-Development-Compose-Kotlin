package com.example.androiddevelopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevelopment.business_card_app.BusinessCardApp
import com.example.androiddevelopment.compose_about_app.ComposeAboutApp
import com.example.androiddevelopment.functions.happyBirthdayPrint
import com.example.androiddevelopment.happy_birthday_ui.HappyBirthdayUi
import com.example.androiddevelopment.state_changing.StateChangingComposable
import com.example.androiddevelopment.ui.theme.AndroidDevelopmentTheme
import com.example.androiddevelopment.variables.creatingVariablesInKotlin


// for running code not UI
//fun main() {
//
//    creatingVariablesInKotlin()
//    mainFunctionCode()
//    val resultOfFunction = happyBirthdayPrint(age = 21); // names parameters : give this func any parameter you want
//    println(resultOfFunction);
//}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevelopmentTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    HappyBirthdayUi(message = "Avazsho", from = "Angular")
//                    ComposeAboutApp()
//                    BusinessCardApp()
                    StateChangingComposable()
                }
            }
        }
    }
}


fun mainFunctionCode() {
    println("hello brothers what is going on? ");
}


@Composable
fun Greeting(name: String? = null, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDevelopmentTheme {
        Greeting("Android")
    }
}