package com.cerabase.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
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
    onCategoryClick: (Int) -> Unit,
    onSearchClick: () -> Unit,
    onAboutClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onTemperatureConverterClick: () -> Unit = {},
    onCustomFormulasClick: () -> Unit = {},
    onMostUsedClick: () -> Unit = {},
    onDailyWorkNotesClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
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
                    IconButton(onClick = onSearchClick) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Ara",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(onClick = onFavoritesClick) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorilerim",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = onAboutClick) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Hakkında",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
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
            items(categories.size) { index ->
                val category = categories[index]
                CategoryCard(
                    icon = category.icon,
                    title = stringResource(id = category.titleRes),
                    description = stringResource(id = category.descriptionRes),
                    onClick = { onCategoryClick(index) }
                )
            }

            item {
                CategoryCard(
                    icon = "📝",
                    title = "Kendi Formüllerim",
                    description = "Özel clay formüllerinizi oluşturun ve kaydedin",
                    onClick = onCustomFormulasClick
                )
            }

            item {
                CategoryCard(
                    icon = "📊",
                    title = "En Çok Kullanılanlar",
                    description = "En sık aranan ve kullanılan içerikleri görüntüleyin",
                    onClick = onMostUsedClick
                )
            }

            item {
                CategoryCard(
                    icon = "🌡️",
                    title = "Sıcaklık Dönüştürücü",
                    description = "Cone, Celsius ve Fahrenheit arasında dönüşüm yapın",
                    onClick = onTemperatureConverterClick
                )
            }

            item {
                CategoryCard(
                    icon = "📋",
                    title = "Günlük Çalışma Notları",
                    description = "Günlük çalışmalarınızı kaydedin ve PDF çıktısı alın",
                    onClick = onDailyWorkNotesClick
                )
            }
        }
    }
}
