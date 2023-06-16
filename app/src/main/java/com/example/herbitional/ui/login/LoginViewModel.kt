package com.example.herbitional.ui.login

import android.util.Log
import androidx.lifecycle.*
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class LoginViewModel (private val repository: MyRepository) : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    fun getSession() = repository.getSession().asLiveData()
    fun login(email: String, password: String){
        viewModelScope.launch {
            try {
                val response = repository.login(email, password)
                val result = response.message
                if(result != null){
                    repository.setToken(response.token)
                    repository.setSession(true)
                }

            }catch (e: Exception){
                Log.e("LoginViewModel", "Onfailure: ${e.message}")
            }
        }
    }
}