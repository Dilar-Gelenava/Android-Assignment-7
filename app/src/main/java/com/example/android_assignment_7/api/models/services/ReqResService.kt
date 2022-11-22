package com.example.android_assignment_7.api.models.services

import com.example.android_assignment_7.api.models.ReqResData
import com.example.android_assignment_7.api.models.User
import retrofit2.Call
import retrofit2.http.*

interface ReqResService {
    @GET("users")
    fun getUsers(@Query("page") page: Int, @Query("per_page") perPage: Int): Call<ReqResData<List<User>>>

    @GET("user")
    fun getUser(@Query("id") id: Long): Call<ReqResData<User>>

    @POST("user")
    fun createUser(@Body user: User): Call<ReqResData<User>>

    @PUT("user")
    fun updateUser(@Body user: User): Call<ReqResData<User>>

    @DELETE("user")
    fun deleteUser(@Query("id") id: Long): Call<ReqResData<User>>
}