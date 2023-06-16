package com.example.herbitional.ui.form.lain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herbitional.api.response.DataItem
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class GejalaLainnyaViewModel(private val repository: MyRepository): ViewModel() {

    private var _predict = MutableLiveData<DataItem>()
    val predict: LiveData<DataItem> = _predict

    fun getPredict(symptoms: String){
        viewModelScope.launch {
            try {
                val response = repository.getPredict(symptoms)
                val result = response.data
                _predict.value = result.firstOrNull()
            }catch (e: Exception){
                Log.e("GejalaLainViewModel", "Onfailure: ${e.message}")
            }
        }

    }

}