package com.vungoclong.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vungoclong.ui.screen.main.MainScreen
import com.vungoclong.ui.screen.welcome.WelcomeScreen
import com.vungoclong.util.Constants.MAIN_SCREEN_ROUTE
import com.vungoclong.util.Constants.WELCOME_SCREEN_ROUTE

@Composable
fun Navigation(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(WELCOME_SCREEN_ROUTE) {
            WelcomeScreen() {
                navController.navigate(MAIN_SCREEN_ROUTE) {
                    popUpTo(WELCOME_SCREEN_ROUTE) { inclusive = true }
                }
            }
        }
        composable(MAIN_SCREEN_ROUTE){
            MainScreen()
        }
    }

}