package com.newreality.composetestapp.presentation.ui.webviewscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WebViewModel : ViewModel() {

    var state by mutableStateOf(WebViewState.HOME)
}