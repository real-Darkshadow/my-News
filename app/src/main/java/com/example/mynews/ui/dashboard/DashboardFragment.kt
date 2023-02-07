package com.example.mynews.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.mynews.Network.apidatanet
import com.example.mynews.databinding.FragmentDashboardBinding
import com.example.mynews.ui.dashboard.apidata.countrydata
import com.example.mynews.ui.dashboard.recyclerview.countryadapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    val url="https://newsapi.org"
    val api="59a52e4a1f1344ebbec722bba583bcdc"
    var datas:countrydata?=null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        getapidata()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    public fun recycle(data: countrydata){
        binding.countryRecycler.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.countryRecycler.adapter= countryadapter(requireContext(),data)
    }




    fun getapidata(){
        val retro=retrofit2.Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        val service=retro.create(apidatanet::class.java)
        val listcall: Call<countrydata> =service.getdata("us","General",api)
        listcall.enqueue(object : Callback<countrydata> {
            override fun onResponse(call: Call<countrydata>, response: Response<countrydata>) {
                if(response.isSuccessful){
                    datas=response.body()
                    recycle(datas!!)
                }
                else{
                    when(response.code()){
                        400->{
                            Log.i("Error 404", "Not Found")
                        }
                    }
                }

            }

            override fun onFailure(call: Call<countrydata>, t: Throwable) {
                Log.e("Errorr", t!!.message.toString())
            }

        })
    }


}