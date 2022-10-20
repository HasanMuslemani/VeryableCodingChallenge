package com.veryable.android.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = Typography(
    defaultFontFamily = FontFamily.SansSerif,
    h1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
)