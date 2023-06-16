package com.example.herbitional

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.herbitional.api.ApiConfig
import com.example.herbitional.data.MyRepository
import com.example.herbitional.data.UserPreference

object Injection {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("token")

    fun provideRepository(context: Context): MyRepository {
        val preferences = UserPreference.getInstance(context.dataStore)
        val apiConfig = ApiConfig
        return MyRepository(apiConfig, preferences)
    }
}