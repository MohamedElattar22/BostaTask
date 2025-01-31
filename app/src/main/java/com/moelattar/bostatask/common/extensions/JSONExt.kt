package com.moelattar.bostatask.common.extensions

import android.util.Log
import com.google.gson.Gson
import java.lang.reflect.Type

fun <M> String.getModelFromJSON(tokenType: Type): M = Gson().fromJson(this, tokenType)

fun <T> String.getModelFromJSONs(type: Type): T? {
    return try {
        val gson = Gson()
        gson.fromJson(this, type)
    } catch (e: Exception) {
        Log.e("JSON Parsing Error", "Error parsing JSON", e)
        null
    }
}

fun <M> M.toJson(): String = Gson().toJson(this)

