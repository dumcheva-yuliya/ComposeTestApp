package com.newreality.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform