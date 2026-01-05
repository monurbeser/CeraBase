package com.cerabase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.cerabase.ui.about.AboutScreen
import com.cerabase.ui.clayformulas.ClayFormulasScreen
import com.cerabase.ui.expansion.ExpansionScreen
import com.cerabase.ui.home.HomeScreen
import com.cerabase.ui.oxides.OxidesScreen
import com.cerabase.ui.search.SearchScreen
import com.cerabase.ui.segercones.SegerConesScreen
import com.cerabase.ui.splash.SplashScreen
import com.cerabase.ui.troubleshooting.TroubleshootingScreen

sealed class Screen {
    object Splash : Screen()
    object Home : Screen()
    object Search : Screen()
    object About : Screen()
    object SegerCones : Screen()
    object Expansion : Screen()
    object Oxides : Screen()
    object ClayFormulas : Screen()
    object Troubleshooting : Screen()
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
                onCategoryClick = { categoryIndex ->
                    currentScreen = when (categoryIndex) {
                        0 -> Screen.SegerCones
                        1 -> Screen.Expansion
                        2 -> Screen.Oxides
                        3 -> Screen.ClayFormulas
                        4 -> Screen.Troubleshooting
                        else -> Screen.Home
                    }
                },
                onSearchClick = { currentScreen = Screen.Search },
                onAboutClick = { currentScreen = Screen.About },
                modifier = modifier
            )
        }
        Screen.About -> {
            AboutScreen(
                onBackClick = { currentScreen = Screen.Home },
                modifier = modifier
            )
        }
        Screen.Search -> {
            SearchScreen(
                onBackClick = { currentScreen = Screen.Home },
                onResultClick = { result ->
                    // Navigate to appropriate category based on result
                    currentScreen = when (result.category) {
                        "seger_cones" -> Screen.SegerCones
                        "expansion" -> Screen.Expansion
                        "oxides" -> Screen.Oxides
                        "clay_formulas" -> Screen.ClayFormulas
                        "troubleshooting" -> Screen.Troubleshooting
                        else -> Screen.Home
                    }
                },
                modifier = modifier
            )
        }
        Screen.SegerCones -> {
            SegerConesScreen(
                onBackClick = { currentScreen = Screen.Home },
                modifier = modifier
            )
        }
        Screen.Expansion -> {
            ExpansionScreen(
                onBackClick = { currentScreen = Screen.Home },
                modifier = modifier
            )
        }
        Screen.Oxides -> {
            OxidesScreen(
                onBackClick = { currentScreen = Screen.Home },
                modifier = modifier
            )
        }
        Screen.ClayFormulas -> {
            ClayFormulasScreen(
                onBackClick = { currentScreen = Screen.Home },
                modifier = modifier
            )
        }
        Screen.Troubleshooting -> {
            TroubleshootingScreen(
                onBackClick = { currentScreen = Screen.Home },
                modifier = modifier
            )
        }
    }
}
