package com.newreality.composetestapp.presentation.ui.webviewscreen

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.newreality.composetestapp.R
import com.newreality.composetestapp.presentation.theme.ComposeTestAppTheme

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WebViewScreenPreview() {
    ComposeTestAppTheme {
        WebViewScreen()
    }
}

@Composable
fun WebViewScreen() {
    val viewModel = WebViewModel()

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController, viewModel = viewModel)
                    },
        content = {
            Column (
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                WebView(
                    viewModel = viewModel
                )
                BottomNavGraph(navController = navController)
            }
        },
        floatingActionButton = {
            FAB()
        },
        floatingActionButtonPosition = FabPosition.Center,
        modifier = Modifier
            .background(Color.White)
    )
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FABPreview() {
    ComposeTestAppTheme {
        FAB()
    }
}

@Composable
fun FAB() {
    FloatingActionButton(
        onClick = {

        },
        content = {
            Icon(
                painter = painterResource(id = R.drawable.bottom_nav_scan),
                contentDescription = null
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomBarPreview() {
    ComposeTestAppTheme {
        BottomBar(navController = rememberNavController(), viewModel = WebViewModel())
    }
}

@Composable
fun BottomBar(navController: NavHostController, viewModel: WebViewModel) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        AddItem(screen = BottomBarScreen.Home, navController = navController, viewModel = viewModel)
        AddItem(screen = BottomBarScreen.Accounts, navController = navController, viewModel = viewModel)
        AddItem(screen = BottomBarScreen.PToP, navController = navController, viewModel = viewModel)
        AddItem(screen = BottomBarScreen.Settings, navController = navController, viewModel = viewModel)
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    navController: NavHostController,
    viewModel: WebViewModel
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val selected = currentDestination?.route == screen.route

    NavigationBarItem(
        selected = selected,
        onClick = {
            viewModel.state = BottomBarScreen.Home.state
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "",
                tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary)
        },
        label = { Text(text = screen.title) },
        colors = NavigationBarItemDefaults.colors(
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
            indicatorColor = MaterialTheme.colorScheme.background
        )
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebView(
    isPreview: Boolean = LocalInspectionMode.current,
    viewModel: WebViewModel
) {

    AndroidView(factory = {
        android.webkit.WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()

            if (!isPreview) {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true

                CookieManager.getInstance().setAcceptCookie(true)
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
            }
        }
    }, update = {
        it.loadUrl(viewModel.state.url)
    })
}

