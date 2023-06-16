package com.example.herbitional.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.herbitional.api.response.RiwayatItem
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class ProfileViewModel (private val repository: MyRepository) : ViewModel() {

    private var _historyList = MutableLiveData<List<RiwayatItem>>()
    val historyList: LiveData<List<RiwayatItem>> = _historyList

    private var _profileName = MutableLiveData<String>()
    val profileName: LiveData<String> = _profileName

    private var _profileEmail = MutableLiveData<String>()
    val profileEmail: LiveData<String> = _profileEmail

    fun getSession() = repository.getSession().asLiveData()
    fun getToken() = repository.getToken().asLiveData()

    fun logout(){
        viewModelScope.launch {
            repository.deleteSession()
        }
    }

    fun getListHistory(token: String){
        viewModelScope.launch {
            try {
                Log.e("Profile ViewModel", token)
                val response = repository.getListHistory(token)
                val result = response.riwayat
                result?.forEach{
                    _historyList.value = _historyList.value?.plus(it)
                }
                    _profileName.value = response.fullname
                    _profileEmail.value = response.userEmail

//                _historyList.value = _historyList.value?.plus(response.riwayat) ?: response.riwayat
            } catch (throwable: Throwable) {
                Log.e("Error occurred: ${throwable.message}", throwable.toString())
            }
        }
    }
}