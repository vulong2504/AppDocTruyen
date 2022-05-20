package com.vungoclong.viewmodel.welcome

import android.content.Context
import androidx.lifecycle.ViewModel
import com.vungoclong.util.Constants

class WelcomeScreenViewModel(
) : ViewModel() {
    fun savaWelcomeScreenState(context: Context) {
        val sharedPreferences =
            context.getSharedPreferences(Constants.MY_SHARE_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(Constants.IS_START_FROM_WELCOME, false)
        editor.apply()
    }
}