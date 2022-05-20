package com.vungoclong

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.vungoclong.navigation.Navigation
import com.vungoclong.ui.theme.AppDocTruyenTheme
import com.vungoclong.ui.viewmodel.splash.SplashViewModel

class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            splashViewModel.isLoading.value
        }

        splashViewModel.getStartDestination(applicationContext)

        setContent {
            AppDocTruyenTheme {
                Navigation(splashViewModel.startDestination.value)
            }
        }
    }

}
