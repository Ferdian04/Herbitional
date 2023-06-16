package com.example.herbitional.ui.search

import android.util.Log
import androidx.lifecycle.*
import com.example.herbitional.api.response.ArtikelItem
import com.example.herbitional.api.response.PredictionsItem
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: MyRepository): ViewModel() {

    private var _medicineList = MutableLiveData<List<PredictionsItem>>()
    val medicineList: LiveData<List<PredictionsItem>> = _medicineList

    fun getSession() = repository.getSession().asLiveData()
    fun getSearchMedicine(query: String) {
        viewModelScope.launch {
            try {
                val response = repository.getSearchMedicine(query)
                _medicineList.value = response.predictions
            }catch (e: Exception){
                Log.e("SearchViewModel", "Onfailure: ${e.message}")
            }
        }
    }

}