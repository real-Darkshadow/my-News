package com.example.mynews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.*
import com.example.mynews.databinding.FragmentHomeBinding
import com.example.mynews.ui.home.recycleView.other_vertical_news_adapter
import com.example.mynews.ui.home.recycleView.othernewsadapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerViews()



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun recyclerViews(){
        binding.horiothernews.layoutManager=LinearLayoutManager(requireContext(), VERTICAL,false)
        binding.horiothernews.adapter= other_vertical_news_adapter(requireContext())
        binding.horiothernews.isNestedScrollingEnabled=true
        binding.othernews.layoutManager=LinearLayoutManager(requireContext(), HORIZONTAL,false)
        binding.othernews.adapter= othernewsadapter(requireContext())
    }
}