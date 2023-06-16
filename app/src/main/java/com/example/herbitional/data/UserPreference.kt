package com.example.herbitional.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

    private val SESSION_TOKEN = stringPreferencesKey("key_token")
    private val SESSION_KEY = booleanPreferencesKey("key_session")

    suspend fun setToken(token: String) {
        dataStore.edit { preferences ->
            preferences[SESSION_TOKEN] = token
        }
    }

    suspend fun setSession(isLogin: Boolean){
        dataStore.edit {preferences ->
            preferences[SESSION_KEY] = isLogin
        }
    }

    fun getSession(): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[SESSION_KEY] ?: false
    }

    fun getToken(): Flow<String> = dataStore.data.map { preferences ->
        preferences[SESSION_TOKEN] ?: ""
    }

    suspend fun clearSession() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        const val SESSION_TOKEN = "key_token"
        const val SESSION_KEY = "key_session"

        @Volatile
        private var INSTANCE: UserPreference? = null

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}