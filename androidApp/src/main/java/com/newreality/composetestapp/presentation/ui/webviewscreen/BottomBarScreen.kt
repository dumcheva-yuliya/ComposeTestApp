package com.newreality.composetestapp.presentation.ui.webviewscreen

import com.newreality.composetestapp.R

sealed class BottomBarScreen(
    val icon: Int,
    val title: String,
    val route: String,
    val state: WebViewState
) {
    object Home: BottomBarScreen(
        R.drawable.bottom_nav_home_inactive,
        "Home",
        "home",
        WebViewState.HOME
    )
    object Accounts: BottomBarScreen(
        R.drawable.bottom_nav_assets_inactive,
        "Accounts",
        "accounts",
        WebViewState.ACCOUNTS
    )
    object PToP: BottomBarScreen(
        R.drawable.bottom_nav_p_to_p_inactive,
        "P2P",
        "p2p",
        WebViewState.P2P
    )
    object Settings: BottomBarScreen(
        R.drawable.bottom_nav_settings_inactive,
        "Settings",
        "settings",
        WebViewState.HOME
    )
}