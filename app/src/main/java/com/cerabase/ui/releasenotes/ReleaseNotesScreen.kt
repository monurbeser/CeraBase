package com.cerabase.ui.releasenotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReleaseNotesScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Sürüm Notları",
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Geri",
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                ReleaseCard(
                    version = "1.2.0",
                    date = "5 Ocak 2025",
                    isCurrent = true,
                    features = listOf(
                        "🎨 Pia Ceramic Branding - Yeni icon ve splash screen",
                        "💾 Kendi Formüllerini Kaydet - Custom clay formula oluştur",
                        "📊 En Çok Kullanılanlar - Trending içerik keşfet",
                        "❤️ Favoriler Sistemi - Sevdiğin içerikleri kaydet",
                        "📋 Copy-to-Clipboard - Teknik verileri kopyala",
                        "🌡️ Sıcaklık Dönüştürücü - C ↔ F ↔ Cone dönüşümü",
                        "ℹ️ About Ekranı - Pia Ceramic bilgisi"
                    ),
                    improvements = listOf(
                        "View tracking tüm ekranlarda",
                        "Dinamik build numarası",
                        "Database versiyonu 2'ye yükseltme",
                        "UI/UX iyileştirmeleri"
                    ),
                    bugFixes = listOf(
                        "BuildConfig import sorunları",
                        "Navigation flow optimizasyonu"
                    )
                )
            }

            item {
                ReleaseCard(
                    version = "1.1.0",
                    date = "Aralık 2024",
                    isCurrent = false,
                    features = listOf(
                        "🔍 Gelişmiş Arama - Tüm kategorilerde full-text arama",
                        "📈 Görüntüleme İstatistikleri - Usage tracking",
                        "🏺 Detail Ekranları - Daha iyi görünüm"
                    ),
                    improvements = listOf(
                        "Arama performansı",
                        "Database yapısı"
                    ),
                    bugFixes = listOf()
                )
            }

            item {
                ReleaseCard(
                    version = "1.0.0",
                    date = "Ekim 2024",
                    isCurrent = false,
                    features = listOf(
                        "🔥 Seger Koni Tabloları - 32 koni referansı",
                        "🎨 Oksitler - 20+ seramik colorant",
                        "📊 Genleşme Katsayıları - 24+ malzeme",
                        "🏺 Clay Formülleri - 13+ professional formül",
                        "🔧 Sorun Giderme - 13+ common problems"
                    ),
                    improvements = listOf(),
                    bugFixes = listOf()
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun ReleaseCard(
    version: String,
    date: String,
    isCurrent: Boolean = false,
    features: List<String> = emptyList(),
    improvements: List<String> = emptyList(),
    bugFixes: List<String> = emptyList()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isCurrent) Color(0xFFFF7F3F).copy(alpha = 0.1f)
                else MaterialTheme.colorScheme.surfaceVariant
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "v$version",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isCurrent) Color(0xFFE85A3F) else MaterialTheme.colorScheme.primary
                )
                Text(
                    text = date,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
            if (isCurrent) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFE85A3F))
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Güncel",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        if (features.isNotEmpty()) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "✨ Yeni Özellikler",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                features.forEach { feature ->
                    Text(
                        text = "• $feature",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 18.sp
                    )
                }
            }
        }

        if (improvements.isNotEmpty()) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "🔧 İyileştirmeler",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFFA500)
                )
                improvements.forEach { improvement ->
                    Text(
                        text = "• $improvement",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 18.sp
                    )
                }
            }
        }

        if (bugFixes.isNotEmpty()) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "🐛 Bug Fixes",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.error
                )
                bugFixes.forEach { fix ->
                    Text(
                        text = "• $fix",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 18.sp
                    )
                }
            }
        }
    }
}
