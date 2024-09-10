package com.newreality.composetestapp.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.newreality.composetestapp.R

private val DarkColorScheme = darkColorScheme(
    primary = ThemeColors.Dark.primary,
    onPrimary = ThemeColors.Dark.onPrimary,
    primaryContainer = ThemeColors.Dark.primaryContainer,
    secondary = ThemeColors.Dark.secondary,
    tertiary = ThemeColors.Dark.background,
    background = ThemeColors.Dark.background,
    outline = ThemeColors.Dark.outline,
    error = ThemeColors.Dark.error
)

private val LightColorScheme = lightColorScheme(
    primary = ThemeColors.Light.primary,
    onPrimary = ThemeColors.Light.onPrimary,
    primaryContainer = ThemeColors.Light.primaryContainer,
    secondary = ThemeColors.Light.secondary,
    tertiary = ThemeColors.Light.background,
    background = ThemeColors.Light.background,
    outline = ThemeColors.Light.outline,
    error = ThemeColors.Light.error
)


data class AppResources(
    @DrawableRes val someDrawable: Int
)

val LocalAppResources = staticCompositionLocalOf<AppResources> {
    error("CompositionLocal LocalAppResources not present")
}

val LightAppResources = AppResources(
    someDrawable = R.drawable.bottom_nav_home_test
)

val DarkAppResources = AppResources(
    someDrawable = R.drawable.bottom_nav_home_test_night
)

@Composable
fun ComposeTestAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val appResources = if (darkTheme) {
        DarkAppResources
    } else {
        LightAppResources
    }

    CompositionLocalProvider(
        LocalAppResources provides appResources,
        content = content
    )

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}