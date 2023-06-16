package com.example.herbitional.ui.login

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.herbitional.MainActivity
import com.example.herbitional.ViewModelVactory

import com.example.herbitional.databinding.ActivityLoginBinding
import com.example.herbitional.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels {
        ViewModelVactory.getInstance(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        forgetPassword()
        login()
        isLoginCheck()
        register()

    }


//    Fungsi lupa password
    private fun forgetPassword(){
        binding.tvForgetPassword.setOnClickListener {
            Toast.makeText(this, "Konten Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
    }


//    Fungsi ketika klik tombol masuk

    private fun login(){
        binding.btnLogin.setOnClickListener {
//            Ke halaman Home
            val email = binding.edLoginEmail.text.toString()
            val password = binding.edLoginPassword.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "Masukkan email terlebih dahulu", Toast.LENGTH_SHORT).show()
            }else if (password.isEmpty()){
                Toast.makeText(this,"Masukkan password terlebih dahulu", Toast.LENGTH_SHORT).show()
            }else if(password.length < 6){
                Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.login(email, password)
            }

        }
    }

//    Fungsi ketika klik tv daftar
    private fun register(){
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }

// Cek Session
    private fun isLoginCheck() {
        viewModel.getSession().observe(this) {
            if (it != null && it == true) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}
