package com.app.dogapp.data.repository

import com.app.dogapp.data.local.MyPreferences
import com.app.dogapp.data.remote.RetrofitClient
import com.google.gson.Gson
import javax.inject.Inject

class DogRepository @Inject constructor(private val preferences: MyPreferences) {
    private val gson = Gson()

    suspend fun fetchRandomDogImage(): String {
        val response = RetrofitClient.apiService.getRandomDogImage()
        return response.message
    }

    fun saveImageToCache(imageUrl: String) {
        val cache = getCache()
        cache.add(imageUrl)
        if (cache.size > 20) cache.removeAt(0) // Keep only 20 items
        preferences.write("dog_cache", gson.toJson(cache))
    }

    // Get cached images
    fun getCachedImages(): List<String> {
        return getCache()
    }

    // Clear cache
    fun clearCache() {
        preferences.clear("dog_cache")
    }

    // Helper function to get cache as List
    private fun getCache(): MutableList<String> {
        val json = preferences.read("dog_cache", null)
        return if (json != null) {
            gson.fromJson(json, Array<String>::class.java).toMutableList()
        } else {
            mutableListOf()
        }
    }

}