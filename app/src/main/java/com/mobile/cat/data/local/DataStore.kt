package com.mobile.cat.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore by preferencesDataStore("theme_preferences")

object ThemePreferencesDataStore {
    private val THEME_KEY = booleanPreferencesKey("is_dark_theme")

    fun isDarkTheme(context: Context): Flow<Boolean> {
        return context.dataStore.data
            .catch { exception ->
                // If an error, emit the default value (false)
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[THEME_KEY] ?: false  // default is light theme
            }
    }

    suspend fun setDarkTheme(context: Context, isDarkTheme: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = isDarkTheme
        }
    }
}