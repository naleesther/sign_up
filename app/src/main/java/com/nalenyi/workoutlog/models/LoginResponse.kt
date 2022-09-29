package com.nalenyi.workoutlog.models

import android.security.identity.AccessControlProfileId
import com.google.gson.annotations.SerializedName
data class LoginResponse(
    var message:String,
    @SerializedName("accessToken") var access_Token:String,
    @SerializedName("user_id") var user_id:String,
    @SerializedName("profile_id") var profile_id:String,





    )
