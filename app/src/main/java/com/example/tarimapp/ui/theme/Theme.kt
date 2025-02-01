package com.example.tarimapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light Color Scheme
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF16697A),       // Active Color (Mavi)
    onPrimary = Color.White,           // Primary üzerindeki yazı rengi
    secondary = Color(0xFF808080),     // Inactive Color (Gri)
    onSecondary = Color.White,         // Secondary üzerindeki yazı rengi
    tertiary = Color(0xFFADD8E6),      // Accent Color (Pastel Mavi)
    background = Color(0xFFFCF4F2),    // Arkaplan (Beyaz)
    onBackground = Color.Black,        // Arkaplan üzerindeki yazı rengi
    surface = Color(0xFFFFFFFF),       // Bileşen arkaplanları (Örn: Card)
    onSurface = Color.Black,           // Surface üzerindeki yazı rengi
    error = Color(0xFFD32F2F),         // Hata rengi (Kırmızı)
    onError = Color.White,             // Hata üzerindeki yazı rengi
)

// Dark Color Scheme
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1E90FF),       // Active Color (Mavi)
    onPrimary = Color.White,           // Primary üzerindeki yazı rengi
    secondary = Color(0xFF808080),     // Inactive Color (Gri)
    onSecondary = Color.White,         // Secondary üzerindeki yazı rengi
    tertiary = Color(0xFFADD8E6),      // Accent Color (Pastel Mavi)
    background = Color(0xFF121212),    // Arkaplan (Koyu Gri)
    onBackground = Color.White,        // Arkaplan üzerindeki yazı rengi
    surface = Color(0xFF1E1E1E),       // Bileşen arkaplanları (Örn: Card)
    onSurface = Color.White,           // Surface üzerindeki yazı rengi
    error = Color(0xFFCF6679),         // Hata rengi (Kırmızı)
    onError = Color.Black,             // Hata üzerindeki yazı rengi
)

@Composable
fun TarimAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Kullanılacak renk şemasını seç
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    // Material Theme uygula
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Typography tanımınızı burada kullanın
        content = content
    )
}