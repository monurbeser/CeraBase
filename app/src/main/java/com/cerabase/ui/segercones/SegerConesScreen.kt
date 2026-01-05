package com.cerabase.ui.segercones

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cerabase.data.model.SegerCone
import com.cerabase.data.model.SegerConeData
import com.cerabase.data.repository.FavoriteRepository
import com.cerabase.data.repository.UsageTrackingRepository
import com.cerabase.ui.components.InfoCard
import com.cerabase.ui.util.ClipboardUtil
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegerConesScreen(
    onBackClick: () -> Unit,
    usageTrackingRepository: UsageTrackingRepository? = null,
    favoriteRepository: FavoriteRepository? = null,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            usageTrackingRepository?.trackView("seger_cones_category", "seger_cones")
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Seger Koni Tabloları") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, "Geri")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Favorites page toggle will be handled by card buttons */ }) {
                        Icon(Icons.Default.FavoriteBorder, "Favorilere Ekle", tint = MaterialTheme.colorScheme.onPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
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
            item {
                InfoCard(
                    text = "Seger konileri, fırın içindeki sıcaklığı ölçmek için kullanılan piramit şeklindeki göstergelerdir. " +
                            "Her koni belirli bir sıcaklıkta eğilir ve bu sayede doğru pişirme sıcaklığına ulaştığınızı anlarsınız."
                )
            }

            items(SegerConeData.cones) { cone ->
                SegerConeCard(
                    cone = cone,
                    favoriteRepository = favoriteRepository,
                    coroutineScope = coroutineScope
                )
            }
        }
    }
}

@Composable
fun SegerConeCard(
    cone: SegerCone,
    favoriteRepository: FavoriteRepository? = null,
    coroutineScope: kotlinx.coroutines.CoroutineScope? = null
) {
    val isFavorite = favoriteRepository?.isFavorite("cone_${cone.number}")
        ?.collectAsState(initial = false)?.value ?: false

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Koni numarası
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = MaterialTheme.shapes.medium
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = cone.number,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Detaylar
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${cone.temperatureCelsius}°C",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "${cone.temperatureFahrenheit}°F",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }

                Text(
                    text = cone.description,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )

                Text(
                    text = cone.usage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            }

            // Favorite button
            IconButton(
                onClick = {
                    coroutineScope?.launch {
                        favoriteRepository?.toggleFavorite(
                            itemId = "cone_${cone.number}",
                            category = "seger_cones",
                            title = "Cone ${cone.number}",
                            subtitle = "${cone.temperatureCelsius}°C / ${cone.temperatureFahrenheit}°F"
                        )
                    }
                }
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (isFavorite) "Favorilerden Çıkart" else "Favorilere Ekle",
                    tint = if (isFavorite) Color(0xFFE85A3F) else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}
