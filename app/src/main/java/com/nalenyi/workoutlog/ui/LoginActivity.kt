package com.nalenyi.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nalenyi.workoutlog.api.ApiClient
import com.nalenyi.workoutlog.api.ApiInterface
import com.nalenyi.workoutlog.databinding.ActivityLoginBinding
import com.nalenyi.workoutlog.models.LoginRequest
import com.nalenyi.workoutlog.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        sharedPreferences=getSharedPreferences("WORKOUT_PREFERENCES", MODE_PRIVATE)

    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))

        })
        userViewModel.errorLiveData.observe(this, Observer { errorMessage->
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show()
        })
    }


    fun castViews(){
       binding.btnLogin.setOnClickListener {
           validateLogin()
       }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))

        }
        userViewModel.errorLiveData.observe(this,{errorMessage->
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show()
        })

    }

    fun validateLogin(){
        var error = false
        binding.tilEmail.error=null
        binding.tilPassword.error=null
        var email = binding.etEmail.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
            error= true
        }
        var Password = binding.etPassword.text.toString()
        if (Password.isBlank()){
            binding.tilPassword.error="Password is required"
            error = error
        }
        if (!error){
            val loginRequest=LoginRequest(email,Password)
            binding.pbLogin.visibility=View.GONE
            userViewModel.loginUser(loginRequest)
        }
    
}
    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPreferences.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.access_Token)
        editor.putString("USER_ID",loginResponse.user_id)
        editor.putString("PROFILE_ID",loginResponse.profile_id)
        editor.apply()
    }
    }