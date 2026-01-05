package com.cerabase.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        // Fade in animation
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 800)
        )
        // Show splash for 2.5 seconds
        delay(2500)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5D4C1)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(alpha.value)
        ) {
            // Ceramic pot icon representation
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFFFF7F3F), shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "🏺",
                    fontSize = 80.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // App name
            Text(
                text = "CeraBase",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE85A3F)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Brand name
            Text(
                text = "Pia Ceramic",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFA67C52)
            )
        }
    }
}
