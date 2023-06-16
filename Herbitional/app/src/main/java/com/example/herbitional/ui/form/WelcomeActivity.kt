package com.example.herbitional.ui.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.herbitional.databinding.ActivityWelcomeBinding
import com.example.herbitional.ui.form.umum.GejalaUmumActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnNext.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, GejalaUmumActivity::class.java))
        }

        binding.ivBack.setOnClickListener {
            finish()
        }

    }
}