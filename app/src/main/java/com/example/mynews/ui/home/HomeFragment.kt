package com.example.mynews.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.*
import com.example.mynews.Network.apidatanet
import com.example.mynews.databinding.FragmentHomeBinding
import com.example.mynews.ui.dashboard.apidata.countrydata
import com.example.mynews.ui.home.recycleView.other_vertical_news_adapter
import com.example.mynews.ui.home.recycleView.othernewsadapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val url="https://newsapi.org"
    val api="59a52e4a1f1344ebbec722bba583bcdc"
    var datas:countrydata?=null
    var sportsdata:countrydata?=null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        getapidata()
        getsportsdata()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun recyclerViews(datas: countrydata) {
        binding.horiothernews.layoutManager=LinearLayoutManager(requireContext(), VERTICAL,false)
        binding.horiothernews.adapter= other_vertical_news_adapter(requireContext(),datas)
        binding.horiothernews.isNestedScrollingEnabled=true

    }
    fun recyclerViewsother(sportdata: countrydata){
        binding.othernews.layoutManager=LinearLayoutManager(requireContext(), HORIZONTAL,false)
        binding.othernews.adapter= othernewsadapter(requireContext(),sportdata)
    }

    private fun getapidata(con:String="in", cat:String="General"){
        val retro=retrofit2.Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        val service=retro.create(apidatanet::class.java)
        val listcall: Call<countrydata> =service.getdata(con,cat, pageSize = 100)
        listcall.enqueue(object : Callback<countrydata> {
            override fun onResponse(call: Call<countrydata>, response: Response<countrydata>) {
                if(response.isSuccessful){
                    datas=response.body()
                    recyclerViews(datas!!)
                    Log.d("data", datas!!.articles.size.toString())
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
    fun getsportsdata(con:String="in",cat:String="sports"){
        val retro=retrofit2.Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        val service=retro.create(apidatanet::class.java)
        val listcall: Call<countrydata> =service.getdata(con,cat,100)
        listcall.enqueue(object : Callback<countrydata> {
            override fun onResponse(call: Call<countrydata>, response: Response<countrydata>) {
                if(response.isSuccessful){
                    sportsdata=response.body()
                    recyclerViewsother(sportsdata!!)
                    Log.d("dataaa",sportsdata!!.articles.size.toString())
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