package com.newreality.wallet.constants

import java.net.URI

fun Constants.authUrl() =
    if (USE_TEST_URL) SERVICE_INT_PAYPOINT
    else NEW_REALITY_AUTH_URL

fun Constants.domain(): String {
    val uri = URI(if (USE_TEST_URL) SERVICE_INT_PAYPOINT
    else NEW_REALITY_AUTH_URL)
    val domain = uri.host
    return domain
}

fun Constants.accountsUrl() =
    if (USE_TEST_URL) ACCOUNTS_SERVICE
    else ACCOUNTS_NEW_REALITY

fun Constants.walletUrl() =
    if (USE_TEST_URL) WALLET_SERVICE
    else JS_WALLET

fun Constants.p2pUrl() =
    if (USE_TEST_URL) P2P_SERVICE
    else JS_P2P

fun Constants.homeUrl() =
    if (USE_TEST_URL) HOME_SERVICE
    else HOME_NEW_REALITY