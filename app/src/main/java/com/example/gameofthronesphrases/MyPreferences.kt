package com.example.gameofthronesphrases

import android.content.Context
import android.content.SharedPreferences

class MyPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    fun saveUserName(userName: String) {
        val editor = sharedPreferences.edit()
        editor.putString("user_name", userName)
        editor.apply()
    }

    fun getUserName(): String? {
        return sharedPreferences.getString("user_name", null)
    }

    fun hasUserName(): Boolean {
        return sharedPreferences.contains("user_name")
    }
}
