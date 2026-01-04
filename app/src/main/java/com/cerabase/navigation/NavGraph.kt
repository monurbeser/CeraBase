package com.cerabase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.cerabase.ui.home.HomeScreen
import com.cerabase.ui.splash.SplashScreen

sealed class Screen {
    object Splash : Screen()
    object Home : Screen()
}

@Composable
fun NavGraph(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Splash) }

    when (currentScreen) {
        Screen.Splash -> {
            SplashScreen(
                onSplashFinished = {
                    currentScreen = Screen.Home
                }
            )
        }
        Screen.Home -> {
            HomeScreen(
                isDarkTheme = isDarkTheme,
                onThemeToggle = onThemeToggle,
                modifier = modifier
            )
        }
    }
}
