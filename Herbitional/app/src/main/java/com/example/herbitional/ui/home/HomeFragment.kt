package com.example.herbitional.ui.home

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.herbitional.MainActivity
import com.example.herbitional.R
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.api.response.ArtikelItem
import com.example.herbitional.data.Medicine
import com.example.herbitional.databinding.FragmentHomeBinding
import com.example.herbitional.ui.form.WelcomeActivity
import com.example.herbitional.ui.login.LoginActivity
import com.example.herbitional.ui.login.LoginViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RecomendationAdapter

    private val viewModel: HomeViewModel by viewModels() {
        ViewModelVactory.getInstance(requireContext())
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnSurvey.setOnClickListener {
            val intent = Intent(requireContext(),WelcomeActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListMedicine()
        getAllMedicine()

    }

    private fun setupListMedicine(){
        viewModel.medicineList.observe(this) {
            showLoading(true)
            if(it!=null){
                adapter = RecomendationAdapter(it)
                binding.rvMedicineRecomendation.layoutManager = LinearLayoutManager(requireContext())
                binding.rvMedicineRecomendation.adapter = adapter
                showLoading(false)
            }
        }
    }

    private fun getAllMedicine() {
        viewModel.getToken().observe(this) {
            if (it != null) {
                viewModel.getAllMedicine(it)
            }
        }
    }

    companion object {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showLoading(state: Boolean){
        if(state){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }
}