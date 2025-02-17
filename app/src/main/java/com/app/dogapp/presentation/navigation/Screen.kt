package com.app.dogapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Home : Screen()

    @Serializable
    object GenerateDogs : Screen()
}