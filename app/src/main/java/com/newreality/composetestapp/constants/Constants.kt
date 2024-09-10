package com.newreality.wallet.constants

object Constants {

    /**         CRUTCH          **/
    const val USE_TEST_URL = false

    /**         URL         **/

    const val NEW_REALITY_AUTH_URL = "https://wallet.newreality.club/"
    const val SERVICE_INT_PAYPOINT = "https://wallet.service.int.paypoint.pro/"

    /**         JavaScript
     * Да, мы просто выполняем кусок JS-кода, имитируя нажатие на ссылку. */
    const val ACCOUNTS_NEW_REALITY = "https://wallet.newreality.club/keyts/list"

    const val ACCOUNTS_SERVICE = "https://wallet.service.int.paypoint.pro/keyts/list"

    const val JS_WALLET = "javascript:" +
            "(function(){" +
                "l=document.querySelector(" +
                    "'#app >" +
                    " div > div.header.navbar.bd-nawbar.p-0 >" +
                    " div.container-fluid.p-0.color_menu_gradient >" +
                    " div > div > div.logo > a > img'" +
                ");" +
                "e=document.createEvent('HTMLEvents');" +
                "e.initEvent('click',true,true);l.dispatchEvent(e);" +
            "})()"

    const val WALLET_SERVICE = "https://wallet.service.int.paypoint.pro/"

    const val JS_P2P = "javascript: (function() {\n" +
            "document.getElementById('/p2p/offers').click();\n" +
            "})()"

    const val P2P_SERVICE = "https://wallet.service.int.paypoint.pro/p2p/offers"

    const val HOME_NEW_REALITY = "https://wallet.newreality.club/"

    const val HOME_SERVICE = "https://wallet.service.int.paypoint.pro/"

    /**         WEB SETTINGS            **/
    const val WV_INTERFACE = "Android"
    const val WV_USER_AGENT = " ppWebViewApp"

    val WV_HEADER = mapOf("webview" to "android")

}