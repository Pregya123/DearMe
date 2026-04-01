package com.example.dearme.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// 🌙 Dark Theme
private val DarkColorScheme = darkColorScheme(
    primary = LightPink,
    secondary = DarkPink,
    background = androidx.compose.ui.graphics.Color(0xFF1E1E1E),
    surface = androidx.compose.ui.graphics.Color(0xFF2C2C2C),
    onPrimary = White,
    onBackground = androidx.compose.ui.graphics.Color(0xFFEADFE3),
    onSurface = androidx.compose.ui.graphics.Color(0xFFEADFE3)
)

// 🌸 Light Theme (MAIN)
private val LightColorScheme = lightColorScheme(
    primary = DarkPink,
    secondary = LightPink,
    background = SoftPink,
    surface = White,
    onPrimary = White,
    onBackground = SoftBrown,
    onSurface = SoftBrown
)

@Composable
fun DearMeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}