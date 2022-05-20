package com.vungoclong.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.vungoclong.ui.screen.welcome.WelcomeScreen
import com.vungoclong.util.Constants.MAIN_SCREEN_HISTORY_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_HOME_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_PROFILE_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_SEARCH_ROUTE
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
        navigation(route = MAIN_SCREEN_ROUTE, startDestination = MAIN_SCREEN_HOME_ROUTE) {
            composable(route = MAIN_SCREEN_HOME_ROUTE) {

            }
            composable(route = MAIN_SCREEN_SEARCH_ROUTE) {

            }
            composable(route = MAIN_SCREEN_HISTORY_ROUTE) {

            }
            composable(route = MAIN_SCREEN_PROFILE_ROUTE) {

            }
        }
    }

}