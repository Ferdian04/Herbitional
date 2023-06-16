package com.example.herbitional.api

import com.example.herbitional.api.response.*
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("/api/v1/auth/register")
    suspend fun register(
        @Field("fullname") name: String,
        @Field("user_email_address") email: String,
        @Field("user_password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("/api/v1/auth/login")
    suspend fun login(
        @Field("user_email_address") email: String,
        @Field("user_password") password: String,
    ): LoginResponse

    @GET("/api/v1/medicine/home")
    suspend fun getMedicine(
    ): HomeResponse

    @GET("/api/v1/medicine/specificmed/{id_artikel}")
    suspend fun getDetailMedicine(
        @Path("id_artikel") id: Int,
    ): DetailMedicineResponse

    @FormUrlEncoded
    @POST("/predict")
    suspend fun getSearchMedicine(
        @Field("input-text") input: String,
    ): SearchResponse

    @FormUrlEncoded
    @POST("api/v1/user/inshistori")
    suspend fun saveHistory(
//        @Field("user_id") id: Int,
        @Field("penyakit_id")id_penyakit: Int
    ): SaveHistoryResponse

    @GET("api/v1/user/profile")
    suspend fun getListHistory(
    ): ProfileResponse

    @GET("/api/v1/diseases/spesificdis/{id_penyakit}")
    suspend fun getDetailHistory(
        @Path("id_penyakit") id: Int,
    ): DetailHistoryResponse

    @FormUrlEncoded
    @POST("/predict")
    suspend fun getPredict(
        @Field("symptoms") symptoms: String
    ): PredictResponse

}