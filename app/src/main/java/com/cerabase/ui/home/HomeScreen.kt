package com.cerabase.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cerabase.R
import com.cerabase.ui.components.CategoryCard

data class Category(
    val icon: String,
    val titleRes: Int,
    val descriptionRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val categories = listOf(
        Category(
            icon = "🔥",
            titleRes = R.string.category_seger_cones,
            descriptionRes = R.string.category_seger_cones_desc
        ),
        Category(
            icon = "📊",
            titleRes = R.string.category_expansion,
            descriptionRes = R.string.category_expansion_desc
        ),
        Category(
            icon = "🎨",
            titleRes = R.string.category_oxides,
            descriptionRes = R.string.category_oxides_desc
        ),
        Category(
            icon = "🏺",
            titleRes = R.string.category_clay_formulas,
            descriptionRes = R.string.category_clay_formulas_desc
        ),
        Category(
            icon = "🔧",
            titleRes = R.string.category_troubleshooting,
            descriptionRes = R.string.category_troubleshooting_desc
        )
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                actions = {
                    IconButton(onClick = onThemeToggle) {
                        Icon(
                            imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                            contentDescription = "Toggle theme",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                CategoryCard(
                    icon = category.icon,
                    title = stringResource(id = category.titleRes),
                    description = stringResource(id = category.descriptionRes),
                    onClick = {
                        Toast.makeText(
                            context,
                            context.getString(R.string.coming_soon),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }
}
