package com.example.herbitional.ui.detail_history

import android.util.Log
import androidx.lifecycle.*
import com.example.herbitional.api.response.DiseaseItem
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class DetailHistoryViewModel(private val repository: MyRepository) : ViewModel() {

    private var _detailHistory = MutableLiveData<DiseaseItem>()
    val detailHistory: LiveData<DiseaseItem> = _detailHistory

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getToken() = repository.getToken().asLiveData()

    fun getDetailHistory(token: String, id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = repository.getDetailHistory(token, id)
                val responseBody = response.artikel
                if (responseBody != null) {
                    _detailHistory.value = responseBody.firstOrNull()
                    _loading.value = false
                }

            } catch (e: Exception) {
                Log.e("DetailHistoryViewModel", "Onfailure: ${e.message}")
                _loading.value = true
            }
        }
    }
}