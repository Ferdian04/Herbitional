package com.example.herbitional.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.herbitional.api.response.ArtikelItem
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class HomeViewModel (private val repository: MyRepository) : ViewModel() {
    private var _medicineList = MutableLiveData<List<ArtikelItem>>()
    val medicineList: LiveData<List<ArtikelItem>> = _medicineList

    fun getToken() = repository.getToken().asLiveData()
//    fun getSession() = repository.getSession().asLiveData()

    fun logout(){
        viewModelScope.launch {
            repository.deleteSession()
        }
    }

    fun getAllMedicine(token: String){
        viewModelScope.launch {
            try {
                Log.e("Home ViewModel", token)
                val response = repository.getAllMedicine(token)
                _medicineList.value = response.artikel
            }catch (e: Exception){
                Log.e("HomeViewModel", "Onfailure: ${e.message}")
            }
        }
    }
}