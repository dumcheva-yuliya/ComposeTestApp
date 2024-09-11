package com.newreality.composetestapp.app.host

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.newreality.composetestapp.presentation.theme.ComposeTestAppTheme
import com.newreality.composetestapp.presentation.ui.webviewscreen.WebViewScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestAppTheme(
                darkTheme = true
            ) {
//                WebView()
                WebViewScreen()
            }
        }
    }

    @Composable
    fun WebView() {
        val url = "https://www.google.ru"
        
        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
            }
        }, update = {
            it.loadUrl(url)
        })
    }
}