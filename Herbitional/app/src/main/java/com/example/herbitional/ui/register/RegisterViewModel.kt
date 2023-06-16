package com.example.herbitional.ui.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository: MyRepository) : ViewModel() {


    private var _messageRespon = MutableLiveData<String>()
    val messageRespon: LiveData<String> = _messageRespon

    fun register(name: String, email: String, password: String){
        viewModelScope.launch {
            try{
                val response = repository.register(name, email, password)
                val result = response.message
                if (response != null){
                    _messageRespon.value = result
                }
            }catch (e: Exception){
                Log.e("RegisterViewModel", "Onfailure: ${e.message}")
            }
        }
    }

}