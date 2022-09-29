package com.nalenyi.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import com.nalenyi.workoutlog.api.ApiClient
import com.nalenyi.workoutlog.api.ApiInterface
import com.nalenyi.workoutlog.databinding.ActivitySignUpBinding
import com.nalenyi.workoutlog.models.RegisterRequest
import com.nalenyi.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import viewmodel.UserViewModel

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castviews()

    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(
            this,
            androidx.lifecycle.Observer { registerResponse ->
                Toast.makeText(baseContext, registerResponse.message, Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext, LoginActivity::class.java))
            })


        userViewModel.registerErrorLiveData.observe(
            this,
            androidx.lifecycle.Observer { registerError ->
                Toast.makeText(baseContext, registerError, Toast.LENGTH_LONG).show()
            })

    }

    fun castviews() {
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun validateSignup() {
        var error = false
        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Not a valid email address"
            error = true
        }
        var password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        var phoneNumber = binding.etPhoneNumber.text.toString()
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "PhoneNumber is required"
            error = true
        }
        var firstName = binding.etFirstName.text.toString()
        if (firstName.isBlank()) {
            binding.tilFirstName.error = "FirstName is required"
            error = true
        }
        var lastName = binding.etLastName.text.toString()
        if (lastName.isBlank()) {
            binding.tillastName.error = "LastName is required"
            error = true
        }
        var confirmpassword = binding.etConfirmPassword.text.toString()
        if (confirmpassword.isBlank()) {
            binding.tilConfirmPassword.error = "Confirm is required"
            error = true
        }
        if (password != confirmpassword) {
            binding.tilConfirmPassword.error = "Wrong Password"
        }
        if (!error) {
            val registerRequest = RegisterRequest(firstName, lastName, phoneNumber, email, password)
            userViewModel.registerUser(registerRequest)
        }
    }

//    fun makeRegisterRequest(registerRequest: RegisterRequest) {
//        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
//        val request = apiClient.registerUser(registerRequest)
//
//    }
}







