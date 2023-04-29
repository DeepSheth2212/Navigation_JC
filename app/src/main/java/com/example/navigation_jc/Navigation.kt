package com.example.navigation_jc

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navContoller = rememberNavController()
    NavHost(navController = navContoller, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navContoller)
        }
        composable(
            route=Screen.DetailScreen.route+"/{name}", // +"?name={name}" for optional parameters
            arguments = listOf(
            navArgument("name"){
                type = NavType.StringType
                defaultValue = "Deep Sheth"
                nullable = true
            }
        )){
            DetailScreen(name = it.arguments?.getString("name"))
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text, onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                      navController.navigate(Screen.DetailScreen.withArgs(text))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Detail Screen")
        }
    }
}

@Composable
fun DetailScreen(name:String?) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize() ){
        Text(text = "Hello ${name}")
    }
}