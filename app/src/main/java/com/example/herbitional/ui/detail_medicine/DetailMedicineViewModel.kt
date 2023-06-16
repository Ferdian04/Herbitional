package com.example.herbitional.ui.detail_medicine

import android.util.Log
import androidx.lifecycle.*
import com.example.herbitional.api.response.ArtikelItem
import com.example.herbitional.api.response.DetailArtikelItem
import com.example.herbitional.data.MyRepository
import kotlinx.coroutines.launch

class DetailMedicineViewModel (private val repository: MyRepository) : ViewModel() {

    private var _detailArtikel = MutableLiveData<DetailArtikelItem>()
    val detailArtikel: LiveData<DetailArtikelItem> = _detailArtikel

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getToken() = repository.getToken().asLiveData()
    fun getDetailMedicine(token: String, id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = repository.getDetailMedicine(token, id)
                val responseBody = response.artikel
                if (responseBody != null){
                    _detailArtikel.value = responseBody.first()
                    _loading.value = false
                }

            }catch (e: Exception){
                Log.e("DetailMedicineViewModel", "Onfailure: ${e.message}")
                _loading.value = true
            }
        }
    }
}