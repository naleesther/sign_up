package com.nalenyi.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("WORKOUT_PREFERENCES", MODE_PRIVATE)

        val accessToken = sharedPreferences.getString("ACCESS_TOKEN","")
        if (accessToken!!.isBlank()){
            startActivity(Intent(this, LoginActivity::class.java))
        }
        else{

        }
        startActivity(Intent(this,HomeActivity::class.java))

    }

    }


