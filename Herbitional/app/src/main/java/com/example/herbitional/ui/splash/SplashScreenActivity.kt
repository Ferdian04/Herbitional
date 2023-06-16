package com.example.herbitional.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import com.example.herbitional.MainActivity
import com.example.herbitional.R
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.databinding.ActivityMainBinding
import com.example.herbitional.databinding.ActivitySplashScreenBinding
import com.example.herbitional.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val viewModel: SplashScreenViewModel by viewModels {
        ViewModelVactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

       isLoginCheck()

    }

    private fun isLoginCheck(){
        viewModel.getSession().observe(this) {
            if (it != null && it == true) {
                Handler().postDelayed(Runnable {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }, 3000)
            }else{
                Handler().postDelayed(Runnable {
                    startActivity(Intent(this,LoginActivity::class.java))
                    finish()
                }, 3000)
            }
        }
    }
}
