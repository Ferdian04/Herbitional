package com.example.herbitional.data

import com.example.herbitional.api.ApiConfig

class MyRepository (
    private val apiConfig: ApiConfig,
    private val preference: UserPreference
) {
//    Login
    suspend fun login(email: String, password: String) = apiConfig.getMainApiService().login(email, password)

//    Register
    suspend fun register(name: String, email: String, password: String) = apiConfig.getMainApiService().register(name, email, password)

//    Logout
    suspend fun deleteSession() = preference.clearSession()

//    Token
    suspend fun setToken(token: String){
        preference.setToken(token)
    }

    fun getToken() = preference.getToken()

//    Session
    suspend fun setSession(isLogin: Boolean){
        preference.setSession(isLogin)
    }

    fun getSession() = preference.getSession()

//    Medicine
    suspend fun getAllMedicine(token: String) = apiConfig.getMainApiService(token).getMedicine()

    suspend fun getDetailMedicine(token: String, id: Int) = apiConfig.getMainApiService(token).getDetailMedicine(id)


//    Search
    suspend fun getSearchMedicine(query: String) = apiConfig.getSearchApiService().getSearchMedicine(query)

//    History
    suspend fun saveHistory(token: String,  id_penyakit: Int) = apiConfig.getMainApiService(token).saveHistory(id_penyakit)

    suspend fun getListHistory(token: String) = apiConfig.getMainApiService(token).getListHistory()

    suspend fun getDetailHistory(token: String, id: Int) = apiConfig.getMainApiService(token).getDetailHistory(id)

//    Predict
    suspend fun getPredict(symptoms: String) = apiConfig.getPredictApiService().getPredict(symptoms)

//    Profile




}