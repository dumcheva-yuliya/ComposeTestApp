package com.newreality.composetestapp.ui.theme

import androidx.compose.ui.graphics.Color

val light_primary = Color(0xFF3567E6)
val light_onPrimary = Color(0xFF232222)
val light_secondary = Color(0xFF555555)
val light_background = Color(0xFFC7E4FF)
val light_primaryContainer = Color(0xFFFFFFFF)
val light_outline = Color(0xFF3567E6)
val light_error = Color(0xFFB72C2C)


val dark_primary = Color(0xFFFFA234)
val dark_onPrimary = Color(0xFFFFFFFF)
val dark_secondary = Color(0xFF555555)
val dark_background = Color(0xFF070F2C)
val dark_primaryContainer = Color(0xFF0E1433)
val dark_outline = Color(0xFF242C49)
val dark_error = Color(0xFFB72C2C)

val Silver = Color(0xFFA9A9A9)
val Black = Color(0xFF000000)
val Transparent = Color(0x00000000)
val Gray20 = Color(0x207A7A7A)
val White50 = Color(0x50FFFFFF)

sealed class ThemeColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val background: Color,
    val primaryContainer: Color,
    val outline: Color,
    val error: Color
) {
    object Dark: ThemeColors(
        primary = dark_primary,
        onPrimary = dark_onPrimary,
        secondary = dark_secondary,
        background = dark_background,
        primaryContainer = dark_primaryContainer,
        outline = dark_outline,
        error = dark_error
    )
    object Light: ThemeColors(
        primary = light_primary,
        onPrimary = light_onPrimary,
        secondary = light_secondary,
        background = light_background,
        primaryContainer = light_primaryContainer,
        outline = light_outline,
        error = light_error
    )
}

