package com.example.herbitional.api

import android.provider.Settings.Global.getString
import com.example.herbitional.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


object ApiConfig {
    const val MAIN_URL = "https://herbitional-v3-hzyvjvw72a-uc.a.run.app/"
    const val SEARCH_URL = "https://search-engine-v5-hzyvjvw72a-uc.a.run.app"
    const val PREDICT_URL = "https://predict-disease-hzyvjvw72a-uc.a.run.app"

    fun getMainApiService(token: String = ""): ApiService = provideApiService(token, MAIN_URL)

    fun getSearchApiService(token: String = ""): ApiService = provideApiService(token, SEARCH_URL)

    fun getPredictApiService(token: String = ""): ApiService = provideApiService(token, PREDICT_URL)

    private fun provideApiService(token: String = "", baseUrl: String): ApiService {

        val authInterceptor = Interceptor { chain ->
            val req = chain.request()
            val requestHeaders = req.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            chain.proceed(requestHeaders)
        }
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

//        Main API
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)

    }
}
