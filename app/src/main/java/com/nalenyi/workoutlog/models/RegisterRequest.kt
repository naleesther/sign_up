package com.nalenyi.workoutlog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_name")var firstName: String,
    @SerializedName("first_name")var lastName: String,
    @SerializedName("phone_number")var phoneNumber: String,
    var email: String,
    var password: String





)
