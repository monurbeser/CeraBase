package com.cerabase.ui.temperatureconverter

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cerabase.data.model.SegerConeData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemperatureConverterScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var celsiusInput by remember { mutableStateOf("") }
    var fahrenheitInput by remember { mutableStateOf("") }
    var coneInput by remember { mutableStateOf("") }

    val celsius = celsiusInput.toDoubleOrNull() ?: 0.0
    val fahrenheit = fahrenheitInput.toDoubleOrNull() ?: 0.0
    val displayCelsius = if (celsiusInput.isNotEmpty()) celsius else (fahrenheit - 32) * 5 / 9
    val displayFahrenheit = if (fahrenheitInput.isNotEmpty()) fahrenheit else (celsius * 9 / 5) + 32
    val displayCone = coneInput.toDoubleOrNull()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Sıcaklık Dönüştürücü",
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Temperature Input Fields
            Text(
                text = "Sıcaklık Dönüşümleri",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            OutlinedTextField(
                value = celsiusInput,
                onValueChange = { celsiusInput = it; fahrenheitInput = "" },
                label = { Text("Celsius (°C)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = fahrenheitInput,
                onValueChange = { fahrenheitInput = it; celsiusInput = "" },
                label = { Text("Fahrenheit (°F)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            // Results
            if (celsiusInput.isNotEmpty() || fahrenheitInput.isNotEmpty()) {
                ResultCard(
                    celsius = displayCelsius,
                    fahrenheit = displayFahrenheit
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Seger Cone Lookup
            Text(
                text = "Seger Koni Ara",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            OutlinedTextField(
                value = coneInput,
                onValueChange = { coneInput = it },
                label = { Text("Seger Koni Numarası (örn: 6, 8, 10)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            if (displayCone != null) {
                val foundCone = SegerConeData.cones.find {
                    it.number.toDoubleOrNull() == displayCone
                }
                if (foundCone != null) {
                    ConeResultCard(cone = foundCone)
                } else {
                    Text(
                        text = "Koni bulunamadı",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.errorContainer,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Reference Table
            Text(
                text = "Hızlı Referans",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            ReferenceTable()

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ResultCard(celsius: Double, fahrenheit: Double) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Sonuç",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TemperatureDisplay(
                value = celsius,
                unit = "°C",
                label = "Celsius"
            )
            TemperatureDisplay(
                value = fahrenheit,
                unit = "°F",
                label = "Fahrenheit"
            )
        }
    }
}

@Composable
private fun TemperatureDisplay(value: Double, unit: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = String.format("%.1f", value),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE85A3F)
        )
        Text(
            text = unit,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}

@Composable
private fun ConeResultCard(cone: com.cerabase.data.model.SegerCone) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFFF7F3F).copy(alpha = 0.1f))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Koni ${cone.number} Bilgileri",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Celsius",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = "${cone.temperatureCelsius}°C",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE85A3F)
                )
            }
            Column {
                Text(
                    text = "Fahrenheit",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = "${cone.temperatureFahrenheit}°F",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE85A3F)
                )
            }
        }

        if (cone.description.isNotEmpty()) {
            Text(
                text = cone.description,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
private fun ReferenceTable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val referenceList = listOf(
            Triple("6", "1222", "2232"),
            Triple("8", "1260", "2300"),
            Triple("10", "1305", "2381"),
            Triple("12", "1335", "2435")
        )

        referenceList.forEach { (cone, celsius, fahrenheit) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Koni $cone",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "${celsius}°C",
                    fontSize = 12.sp,
                    color = Color(0xFFE85A3F),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "${fahrenheit}°F",
                    fontSize = 12.sp,
                    color = Color(0xFFE85A3F),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
