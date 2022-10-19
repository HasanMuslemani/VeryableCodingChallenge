package com.veryable.android.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = blue,
    primaryVariant = darkBlue,
    onPrimary = white,
    secondary = white,
    secondaryVariant = lightGray,
    onSecondary = darkGray,
)

@get:Composable
val Colors.onSecondaryVariant: Color
    get() = gray

@Composable
fun BankTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = typography,
        content = content
    )
}