package com.nalenyi.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.nalenyi.workoutlog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
  lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
      setContentView(binding.root)

        binding.tvLogin.setOnClickListener { validateSignup()
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        binding.btnSignUp.setOnClickListener { validateSignup() }

    }

        fun validateSignup() {
            var error = false
            var email = binding.etEmail.text.toString()
            if (email.isBlank()) {
                binding.tilEmail.error = "Email is required"
                error = true
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.tilEmail.error = "Not a valid email address"
                error = true
            }
            var password = binding.etPassword.text.toString()
            if (password.isBlank()) {
                binding.tilPassword.error = "Password is required"
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
            if (password !=confirmpassword){
                binding.tilConfirmPassword.error="Wrong Password"
            }


        }

    }


