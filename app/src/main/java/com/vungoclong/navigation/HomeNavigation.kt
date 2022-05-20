package com.vungoclong.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vungoclong.util.Constants.MAIN_SCREEN_HISTORY_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_HOME_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_PROFILE_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_SEARCH_ROUTE

fun NavGraphBuilder.homeNavigation(
    navController: NavHostController
){
    navigation(route = MAIN_SCREEN_ROUTE, startDestination = "home"){
        composable(route = MAIN_SCREEN_HOME_ROUTE){

        }
        composable(route = MAIN_SCREEN_SEARCH_ROUTE){

        }
        composable(route = MAIN_SCREEN_HISTORY_ROUTE){

        }
        composable(route = MAIN_SCREEN_PROFILE_ROUTE){

        }
    }
}