package com.example.mynews.ui.dashboard

import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.Network.apidatanet
import com.example.mynews.databinding.FragmentDashboardBinding
import com.example.mynews.ui.dashboard.apidata.Article
import com.example.mynews.ui.dashboard.apidata.countrydata
import com.example.mynews.ui.dashboard.recyclerview.countryadapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class DashboardViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text








}