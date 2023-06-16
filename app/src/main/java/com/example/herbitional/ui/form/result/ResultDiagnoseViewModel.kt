package com.example.herbitional.ui.form.result

import android.util.Log
import androidx.lifecycle.*
import com.example.herbitional.api.response.SaveHistoryResponse
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class ResultDiagnoseViewModel(private val repository: MyRepository): ViewModel() {

    private var _saveDiagnose = MutableLiveData<SaveHistoryResponse>()
    val saveDiagnose: LiveData<SaveHistoryResponse> = _saveDiagnose

    fun getToken() = repository.getToken().asLiveData()

    fun saveHistory(token: String, id_penyakit: Int){
        viewModelScope.launch {
            try {
                val response = repository.saveHistory(token, id_penyakit)
                val result = response.status
                _saveDiagnose.value = response
            }catch (e: Exception){
                Log.e("ResultViewModel", "Onfailure: ${e.message}")
            }
        }
    }

}