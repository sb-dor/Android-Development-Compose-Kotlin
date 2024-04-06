package com.example.androiddevelopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
import kotlin.reflect.typeOf


// for running code not UI
//fun main() {
//
//    creatingVariablesInKotlin()
//    mainFunctionCode()
//    val resultOfFunction =
//        happyBirthdayPrint(age = 21); // names parameters : give this func any parameter you want
//    println(resultOfFunction);
//
//
//    WhenStateMent()
//
//    val productOb =
//        Product(cQty = 5.0, qPrice = 10.5, cCategory = Category(cId = 1, cName = "Fruits"));
//
//    val totalOfProd = productOb.total();
//
//    val productCategory = productOb.getCategoryName();
//
//    println("total of prod is: $totalOfProd | category name: $productCategory");
//
//
//    val character: Character = RedSide("Avaz", M416(35));
//
//
//    character.fire();
//
//
//    //
//
//    val smartTelevision: SmartTelevision = LGTelevision("PANASONIC");
//
//    print("tvname: ${smartTelevision.nameOfTV}")
//
//    smartTelevision.switchOn()
//
//    smartTelevision.incrementChannel();
//
//    smartTelevision.decrementChannel();
//
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