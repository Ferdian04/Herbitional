package com.example.herbitional.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.herbitional.data.MyRepository

class SplashScreenViewModel (private val repository: MyRepository) : ViewModel() {

    fun getSession() = repository.getSession().asLiveData()
}