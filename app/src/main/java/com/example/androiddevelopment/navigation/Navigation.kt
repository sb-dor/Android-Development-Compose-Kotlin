package com.example.androiddevelopment.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


enum class Screens {
    FirstScreen, SecondScreen,
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navigationController = rememberNavController(); // better way to put this in viewmodel

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Navigation") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray)
        )
    }) { paddingValues ->
        NavigationSettings(paddingValues = paddingValues, navigationController)
    }
}

@Composable
private fun NavigationSettings(
    paddingValues: PaddingValues, navigationController: NavHostController
) {

    // but I think that sending data through navigation with arguments is not the right way

    // do it with ViewModel instead

    NavHost(navController = navigationController, startDestination = Screens.FirstScreen.name) {
        composable(
            route = Screens.FirstScreen.name,

            ) {
            FirstNavigationComposable(paddingValues, navigationController)
        }
        composable(
            route = Screens.SecondScreen.name + "/{name}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType // type of getting data
                defaultValue = "Hello"
                nullable = true
            })
        ) { path ->

            var args = path.arguments?.getString("name");

            SecondNavigationComposableScreen(paddingValues, navigationController, args)
        }
    }
}

