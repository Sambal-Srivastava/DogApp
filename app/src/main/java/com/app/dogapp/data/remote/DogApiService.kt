package com.app.dogapp.data.remote

import com.app.dogapp.domain.model.DogImageResponse
import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): DogImageResponse
}