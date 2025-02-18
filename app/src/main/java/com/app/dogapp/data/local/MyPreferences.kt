package com.app.dogapp.data.local

import android.content.Context
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPreferences @Inject constructor(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("DogCache", Context.MODE_PRIVATE)

    fun write(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun read(key: String, defaultValue: String? = null): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun clear(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }
}