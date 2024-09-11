package com.newreality.composetestapp.presentation.ui.webviewscreen

import com.newreality.wallet.constants.Constants
import com.newreality.wallet.constants.accountsUrl
import com.newreality.wallet.constants.authUrl
import com.newreality.wallet.constants.homeUrl
import com.newreality.wallet.constants.p2pUrl
import com.newreality.wallet.constants.walletUrl

enum class WebViewState(val url: String) {
    HOME(Constants.homeUrl()),
    ACCOUNTS(Constants.accountsUrl()),
    WALLET(Constants.walletUrl()),
    START(Constants.authUrl()),
    P2P(Constants.p2pUrl())
}

sealed interface WebViewScreenState {
    object Home : WebViewScreenState
    object Accounts : WebViewScreenState
    object Start : WebViewScreenState
    object P2P : WebViewScreenState
}