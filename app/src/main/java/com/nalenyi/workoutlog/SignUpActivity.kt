package com.nalenyi.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    lateinit var btnSignup: Button
    lateinit var tilFirstName: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tillastName: TextInputLayout
    lateinit var etLastName: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tilConfirmPassword: TextInputLayout
    lateinit var etConfirmPassword: TextInputEditText
    lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_sign_up)

        tilFirstName = findViewById(R.id.tilFirstName)
        etFirstName = findViewById(R.id.etFirstName)
        tillastName = findViewById(R.id.tillastName)
        etLastName = findViewById(R.id.etLastName)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)

        btnSignup = findViewById(R.id.btnSignUp)
        tvLogin = findViewById(R.id.tvLogin)
        tvLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignup.setOnClickListener { validateSignup() }

    }

        fun validateSignup() {
            var error = false
            var email = etEmail.text.toString()
            if (email.isBlank()) {
                tilEmail.error = "Email is required"
                error = true
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                tilEmail.error = "Not a valid email address"
                error = true
            }
            var password = etPassword.text.toString()
            if (password.isBlank()) {
                tilPassword.error = "Password is required"
                error = true
            }
            var firstName = etFirstName.text.toString()
            if (firstName.isBlank()) {
                tilFirstName.error = "FirstName is required"
                error = true
            }
            var lastName = etLastName.text.toString()
            if (lastName.isBlank()) {
                tillastName.error = "LastName is required"
                error = true
            }
            var confirmpassword = etConfirmPassword.text.toString()
            if (confirmpassword.isBlank()) {
                tilConfirmPassword.error = "Confirm is required"
                error = true
            }
            if (password !=confirmpassword){
                tilConfirmPassword.error="Wrong Password"
            }


        }

    }


