package com.example.herbitional

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.herbitional.data.MyRepository
import com.example.herbitional.ui.detail_history.DetailHistoryViewModel
import com.example.herbitional.ui.detail_medicine.DetailMedicineViewModel
import com.example.herbitional.ui.form.lain.GejalaLainnyaActivity
import com.example.herbitional.ui.form.lain.GejalaLainnyaViewModel
import com.example.herbitional.ui.form.result.ResultDiagnoseViewModel
import com.example.herbitional.ui.home.HomeViewModel
import com.example.herbitional.ui.login.LoginViewModel
import com.example.herbitional.ui.profile.ProfileViewModel
import com.example.herbitional.ui.register.RegisterViewModel
import com.example.herbitional.ui.search.SearchViewModel
import com.example.herbitional.ui.splash.SplashScreenViewModel

class ViewModelVactory (private val repository: MyRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }

            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }

            modelClass.isAssignableFrom(ProfileViewModel::class.java) ->{
                ProfileViewModel(repository) as T
            }

            modelClass.isAssignableFrom(HomeViewModel::class.java) ->{
                HomeViewModel(repository) as T
            }

            modelClass.isAssignableFrom(DetailMedicineViewModel::class.java) -> {
                DetailMedicineViewModel(repository) as T
            }

            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                SearchViewModel(repository) as T
            }

            modelClass.isAssignableFrom(DetailHistoryViewModel::class.java) ->{
                DetailHistoryViewModel(repository) as T
            }

            modelClass.isAssignableFrom(GejalaLainnyaViewModel::class.java) ->{
                GejalaLainnyaViewModel(repository) as T
            }

            modelClass.isAssignableFrom(ResultDiagnoseViewModel::class.java)->{
                ResultDiagnoseViewModel(repository) as T
            }

            modelClass.isAssignableFrom(SplashScreenViewModel::class.java)->{
                SplashScreenViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelVactory? = null
        fun getInstance(context: Context): ViewModelVactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelVactory(Injection.provideRepository(context))
            }.also { instance = it }
    }
}