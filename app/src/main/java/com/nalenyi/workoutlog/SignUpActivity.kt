package com.nalenyi.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var btnSignup:Button
    lateinit var tilFirstName:TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilLastName: TextInputLayout
    lateinit var etLastName: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tilConfirmPassword:TextInputLayout
    lateinit var etConfirmPassword:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        castviews()

    }
    fun castviews(){
        btnLogin=findViewById(R.id.btnLogin)
        btnSignup=findViewById(R.id.btnSignUp)
        tilEmail=findViewById(R.id.tilEmail)
        etEmail=findViewById(R.id.etEmail)
        tilFirstName=findViewById(R.id.tilFirstName)
        etFirstName=findViewById(R.id.etFirstName)
        tilLastName=findViewById(R.id.tilLastName)
        etLastName=findViewById(R.id.etLastName)
        tilPassword=findViewById(R.id.tilPassword)
        etPassword=findViewById(R.id.etPassword)
        tilConfirmPassword=findViewById(R.id.ConfirmPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)

    }


}