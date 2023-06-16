package com.example.herbitional.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.viewModels
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.herbitional.R
import com.example.herbitional.ViewModelVactory
import com.example.herbitional.api.response.RiwayatItem
import com.example.herbitional.data.Disease
import com.example.herbitional.databinding.FragmentHomeBinding
import com.example.herbitional.databinding.FragmentProfileBinding
import com.example.herbitional.ui.home.RecomendationAdapter
import com.example.herbitional.ui.login.LoginActivity



class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

//    private lateinit var recyclerView: RecyclerView

    private val viewModel: ProfileViewModel by viewModels{
        ViewModelVactory.getInstance(requireContext().applicationContext)
    }

    private lateinit var adapter: HistoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        isLoginCheck()
        getListHistory()
        setupListHistory()
        showAlertDialog()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container,false)

//        recyclerView = view.findViewById<RecyclerView>(R.id.rv_history_list)

        val buttonLogout = view.findViewById<ImageView>(R.id.iv_logout)
        buttonLogout.setOnClickListener {
            showLogOutDialog()
        }
        return view
    }

    companion object {

    }

    //    Cek session
    private fun isLoginCheck() {
        viewModel.getSession().observe(this) {
            if (it != null && it == false) {
                val intent = Intent(requireContext(),LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

//    @BindingAdapter("diseaseList")
//    fun bindDiseaseList(recyclerView: RecyclerView, diseaseList: List<RiwayatItem>?){
//        val adapter = getOrCreateAdapter(recyclerView)
//        adapter.updateItems(diseaseList)
//    }

//    private fun getOrCreateAdapter(recyclerView: RecyclerView): HistoryAdapter {
//        return if (recyclerView.adapter != null && recyclerView.adapter is HistoryAdapter) {
//            recyclerView.adapter as HistoryAdapter
//        } else {
//            val historyAdapter = HistoryAdapter()
//            recyclerView.adapter = historyAdapter
//            historyAdapter
//        }
//    }


//    private fun setupListHistory(){
//        viewModel.historyList.observe(this) {
////            showLoading(true)
//            if(it!=null){
//               bindDiseaseList(recyclerView, it)
//
////                showLoading(false)
//            }
//        }
//    }

    private fun setupProfile(){
        viewModel.profileName.observe(this){
            if (it != null){
                Log.e("cek", it)
//                binding.tvName.text = it.
            }
        }
    }

    private fun setupListHistory(){
        viewModel.historyList.observe(this) {
//            showLoading(true)
            if(it!=null){
               adapter = HistoryAdapter(it)
                binding.rvHistoryList.layoutManager = LinearLayoutManager(requireContext())
                binding.rvHistoryList.adapter = adapter
//                showLoading(false)
            }
        }
    }

    private fun getListHistory() {
        viewModel.getToken().observe(this) {
            if (it != null) {
                viewModel.getListHistory(it)
            }
        }
    }

    private fun showLogOutDialog(){
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_logout, null)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)

        val dialog = dialogBuilder.show()

        val btnCancel = dialogView.findViewById<Button>(R.id.btn_cancel)
        val btnLogOut = dialogView.findViewById<Button>(R.id.btn_logout)

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        btnLogOut.setOnClickListener {
            viewModel.logout()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finishAffinity()
            dialog.dismiss()
        }
    }

    private fun showAlertDialog(){
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_on_progress, null)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)

        val dialog = dialogBuilder.show()

        val btnOke = dialogView.findViewById<Button>(R.id.btn_oke)

        btnOke.setOnClickListener {
            dialog.dismiss()
        }
    }



//    private fun showLoading(state: Boolean){
//        if(state){
//            binding.progressBar.visibility = View.VISIBLE
//        }else{
//            binding.progressBar.visibility = View.GONE
//        }
//    }
}