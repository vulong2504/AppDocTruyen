package com.vungoclong.ui.viewmodel.splash

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vungoclong.util.Constants
import com.vungoclong.util.Constants.IS_START_FROM_WELCOME
import com.vungoclong.util.Constants.MY_SHARE_PREFERENCES
import com.vungoclong.util.Constants.SPLASH_SCREEN_DURATION
import com.vungoclong.util.Constants.WELCOME_SCREEN_ROUTE
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashViewModel(
) : ViewModel() {

    val isLoading: MutableState<Boolean> = mutableStateOf(true)
    val startDestination: MutableState<String> = mutableStateOf(WELCOME_SCREEN_ROUTE)

    fun getStartDestination(context: Context) {
        viewModelScope.launch {
            val sharedpreferences =
                context.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE)
            startDestination.value =
                if (sharedpreferences.getBoolean(IS_START_FROM_WELCOME, true)) {
                    WELCOME_SCREEN_ROUTE
                } else {
                    Constants.MAIN_SCREEN_ROUTE
                }
            delay(SPLASH_SCREEN_DURATION)
            isLoading.value = false
        }
    }

}