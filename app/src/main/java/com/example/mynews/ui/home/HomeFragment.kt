package com.example.mynews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.mynews.databinding.FragmentHomeBinding
import com.example.mynews.ui.dashboard.recycleView.selectoradapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.selectorChipsRecycler.layoutManager=LinearLayoutManager(requireContext(), HORIZONTAL,false)
        binding.selectorChipsRecycler.adapter=selectoradapter(requireContext())


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}