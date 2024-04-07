package com.example.androiddevelopment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevelopment.app_architechture.ui.AppArchitecture
import com.example.androiddevelopment.app_architechture_viewmodel.ui.pages.AppArchitectureViewModelPage
import com.example.androiddevelopment.kotlin_concepts.functions.happyBirthdayPrint
import com.example.androiddevelopment.kotlin_concepts.oop.Category
import com.example.androiddevelopment.kotlin_concepts.oop.Product
import com.example.androiddevelopment.kotlin_concepts.oop.cs.Character
import com.example.androiddevelopment.kotlin_concepts.oop.cs.RedSide
import com.example.androiddevelopment.kotlin_concepts.oop.cs.weapon.M416
import com.example.androiddevelopment.kotlin_concepts.oop.open_class.LGTelevision
import com.example.androiddevelopment.kotlin_concepts.oop.open_class.SmartTelevision
import com.example.androiddevelopment.kotlin_concepts.when_statement.WhenStateMent
import com.example.androiddevelopment.state_changing.StateChangingComposable
import com.example.androiddevelopment.ui.theme.AndroidDevelopmentTheme
import com.example.androiddevelopment.kotlin_concepts.variables.creatingVariablesInKotlin
import com.example.androiddevelopment.navigation.Navigation
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.reflect.typeOf


// for running code not UI
fun main() {

    creatingVariablesInKotlin()
    mainFunctionCode()
    val resultOfFunction =
        happyBirthdayPrint(age = 21); // names parameters : give this func any parameter you want
    println(resultOfFunction);


    WhenStateMent()

    val productOb =
        Product(cQty = 5.0, qPrice = 10.5, cCategory = Category(cId = 1, cName = "Fruits"));

    val totalOfProd = productOb.total();

    val productCategory = productOb.getCategoryName();

    println("total of prod is: $totalOfProd | category name: $productCategory");


    val character: Character = RedSide("Avaz", M416(35));


    character.fire();


    //

    val smartTelevision: SmartTelevision = LGTelevision("PANASONIC");

    print("tvname: ${smartTelevision.nameOfTV}")

    smartTelevision.switchOn()

    smartTelevision.incrementChannel();

    smartTelevision.decrementChannel();


    // suspend functions is look like Dart's Future functions, meaning that function will done its work in the future

    // that is why we need "coroutines" in Kotlin in order to run suspend functions

    // "runBlocking" runs code like using "async" in Dart

    runBlocking {
        printForeCast()

        printTemperature()
    }

    // but what if you want to run code "concurrency!" at the same time ?

    // for running several "suspend" function at same time use launch method of coroutine's package
    runBlocking {
        launch {
            printWhatTheDart()
        }
        launch {
            printWhatTheFlutter()
        }

        // like Future -> async (Deferred is like Future)
        val gettingSomething: Deferred<String> = async { somethingInTheFuture(); }

        // then fun await function
        val value = gettingSomething.await()

        println(value)

        //
    }
}


suspend fun printForeCast() {
    delay(1000)
    println("sunny");
}

suspend fun printTemperature() {
    delay(1000)
    println("infinite degrees")
}

suspend fun printWhatTheDart() {
    delay(1000)
    println("What the dart")
}

suspend fun printWhatTheFlutter() {
    delay(1000)
    println("what the flutter?")
}


suspend fun somethingInTheFuture(): String {
    delay(2000)
    return "get your something";
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate Called")
        setContent {
            AndroidDevelopmentTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    HappyBirthdayUi(message = "Avazsho", from = "Angular")
//                    ComposeAboutApp()
//                    BusinessCardApp()
//                    StateChangingComposable()
//                    AppArchitecture()
//                    AppArchitectureViewModelPage()
                    Navigation()
                }
            }
        }
    }


    // Activity's lifecycle
    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "onRestart Called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy Called")
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