package com.vungoclong.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.vungoclong.R
import com.vungoclong.util.Constants.MAIN_SCREEN_HISTORY_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_HOME_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_PROFILE_ROUTE
import com.vungoclong.util.Constants.MAIN_SCREEN_SEARCH_ROUTE

sealed class MainScreenTab(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    object Home : MainScreenTab(
        MAIN_SCREEN_HOME_ROUTE,
        R.string.home,
        R.drawable.ic_book
    )

    object Search : MainScreenTab(
        MAIN_SCREEN_SEARCH_ROUTE,
        R.string.search_story,
        R.drawable.ic_search
    )

    object History : MainScreenTab(
        MAIN_SCREEN_HISTORY_ROUTE,
        R.string.history,
        R.drawable.ic_history
    )

    object Profile : MainScreenTab(
        MAIN_SCREEN_PROFILE_ROUTE,
        R.string.profile,
        R.drawable.ic_person
    )
}
