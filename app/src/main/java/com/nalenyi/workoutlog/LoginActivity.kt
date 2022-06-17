package com.nalenyi.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.nalenyi.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
    }
    fun castViews(){
       binding.btnLogin.setOnClickListener { validateLogin()
           startActivity(Intent(this,HomeActivity::class.java))


       }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))

        }

    }

    fun validateLogin(){
        var error = false
//        tilEmail.error=null
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
    }
    
    
}
    }