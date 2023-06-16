package com.example.herbitional

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import com.example.herbitional.databinding.ActivityMainBinding
import com.example.herbitional.databinding.ActivitySplashScreenBinding
import com.example.herbitional.ui.home.HomeFragment
import com.example.herbitional.ui.profile.ProfileFragment
import com.example.herbitional.ui.register.RegisterActivity
import com.example.herbitional.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else ->{
//                        ToDo
                }
            }
            true
        }

    }

//    Fungsi Transaksi Fragment
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }
}