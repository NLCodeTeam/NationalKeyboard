package ru.nlct.nationalkeyboard.di.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val caption = Color.DarkGray
val divider_color = Color.LightGray
private val red = Color(0xFFE30425)
private val white = Color.White
private val purple_700 = Color(0xFF720D5D)
private val purple_800 = Color(0xFF5D1049)
private val purple_900 = Color(0xFF4E0D3A)

private val DarkColorPalette = darkColors(
    primary = purple_700,
    primaryVariant = purple_800,
    secondary = red,
    surface = purple_900,
    onSurface = white,
)

private val LightColorPalette = lightColors(
    primary = purple_800,
    primaryVariant = purple_700,
    secondary = red,
    surface = purple_900,
    onSurface = white,
)

@Composable
fun NationalKeyboardTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}