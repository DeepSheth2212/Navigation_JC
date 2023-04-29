package com.example.navigation_jc

sealed class Screen(val route:String){
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach{
                append("/$it")
            }
            //vararg is used when we need to pass the variable number of arguments in function..in above function we can pass zero or more no of arguments
        }
    }
}

//sealed class only allows classes under it to inherit

//if some other class from different file tries to inherit this sealed class it cant...
