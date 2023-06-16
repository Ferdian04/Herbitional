package com.example.herbitional.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.herbitional.R
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.data.Medicine
import com.example.herbitional.databinding.FragmentHomeBinding
import com.example.herbitional.databinding.FragmentSearchBinding
import com.example.herbitional.ui.home.HomeViewModel
import com.example.herbitional.ui.home.RecomendationAdapter
import com.example.herbitional.ui.login.LoginActivity
import retrofit2.http.Query


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels() {
        ViewModelVactory.getInstance(requireContext())
    }

    private lateinit var adapter: MedicineAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

//        Ketika input
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                showLoading(true)
                if (query != null){
                    searchMedicine(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isLoginCheck()
        setupListMedicine()

    }

    companion object {

    }

    private fun isLoginCheck() {
        viewModel.getSession().observe(this) {
            if (it != null && it == false) {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setupListMedicine(){
        viewModel.medicineList.observe(this) {
            if(it!=null){
                if (it.isEmpty()) {
                    Toast.makeText(requireContext(), "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
                }
                adapter = MedicineAdapter(it)
                binding.rvMedicineList.layoutManager = LinearLayoutManager(requireContext())
                binding.rvMedicineList.adapter = adapter
                showLoading(false)
            }
        }

    }

    private fun searchMedicine(query: String){
        viewModel.getSearchMedicine(query)
    }

    private fun showLoading(state: Boolean){
        if(state){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }

}