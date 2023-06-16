package com.example.herbitional.ui.register

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.herbitional.MainActivity
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.databinding.ActivityRegisterBinding
import com.example.herbitional.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels {
        ViewModelVactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        register()
        backToLogin()
    }


//    Fungsi ketika tekan tombol daftar
    private fun register(){
        binding.btnRegister.setOnClickListener {
            val name = binding.edRegisterName.text.toString()
            val email = binding.edRegisterEmail.text.toString()
            val password = binding.edRegisterPassword.text.toString()

            if (name.isEmpty()){
                Toast.makeText(this, "Masukkan nama terlebih dahulu", Toast.LENGTH_SHORT).show()
            }else if (email.isEmpty()){
                Toast.makeText(this, "Masukkan email terlebih dahulu", Toast.LENGTH_SHORT).show()
            }else if (password.isEmpty()){
                Toast.makeText(this,"Masukkan password terlebih dahulu", Toast.LENGTH_SHORT).show()
            }else if(password.length < 6){
                Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.register(name, email, password)
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
        }
        viewModel.messageRespon.observe(this){message ->
            if (message != null){
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }

//    Fungsi ketika tekan tulisan masuk
    private fun backToLogin(){
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}