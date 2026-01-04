package com.cerabase.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cerabase.data.datastore.ThemePreferences
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val themePreferences = ThemePreferences(application)

    val isDarkTheme: StateFlow<Boolean> = themePreferences.isDarkTheme
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun toggleTheme() {
        viewModelScope.launch {
            themePreferences.setDarkTheme(!isDarkTheme.value)
        }
    }
}
