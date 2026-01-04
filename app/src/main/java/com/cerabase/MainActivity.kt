package com.cerabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cerabase.navigation.NavGraph
import com.cerabase.ui.home.HomeViewModel
import com.cerabase.ui.theme.CeraBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash screen API
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: HomeViewModel = viewModel()
            val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle()

            CeraBaseTheme(darkTheme = isDarkTheme) {
                NavGraph(
                    isDarkTheme = isDarkTheme,
                    onThemeToggle = viewModel::toggleTheme
                )
            }
        }
    }
}
