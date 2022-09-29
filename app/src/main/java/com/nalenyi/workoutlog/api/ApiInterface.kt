package com.nalenyi.workoutlog.api

import com.nalenyi.workoutlog.models.LoginRequest
import com.nalenyi.workoutlog.models.LoginResponse
import retrofit2.Call
import com.nalenyi.workoutlog.models.RegisterRequest
import com.nalenyi.workoutlog.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("/login")
    suspend fun loginUser (@Body loginRequest: LoginRequest):Response<LoginResponse>
}