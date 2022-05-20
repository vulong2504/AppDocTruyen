package com.vungoclong.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vungoclong.ui.screen.main.history.HistoryScreen
import com.vungoclong.ui.screen.main.home.HomeScreen
import com.vungoclong.ui.screen.main.profile.ProfileScreen
import com.vungoclong.ui.screen.main.search.SearchScreen
import com.vungoclong.ui.theme.colorMain
import com.vungoclong.ui.theme.colorUnselected
import com.vungoclong.util.MainScreenTab

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val items = listOf(
        MainScreenTab.Home,
        MainScreenTab.Search,
        MainScreenTab.History,
        MainScreenTab.Profile,
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        selectedContentColor = colorMain,
                        unselectedContentColor = colorUnselected,
                        alwaysShowLabel = false,
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(screen.label)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = MainScreenTab.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(MainScreenTab.Home.route) {
                HomeScreen()
            }
            composable(MainScreenTab.Search.route) {
                SearchScreen()
            }
            composable(MainScreenTab.History.route) {
                HistoryScreen()
            }
            composable(MainScreenTab.Profile.route) {
                ProfileScreen()
            }
        }
    }

}