package com.app.dogapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DogImageResponse(
    val message: String,
    val status: String
)