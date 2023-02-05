package com.example.mynews.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mynews.R
import com.example.mynews.databinding.FragmentProfileBinding

class profile : Fragment() {
    private  var _binding:FragmentProfileBinding?=null
    val binding get()=_binding!!
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentProfileBinding.inflate(inflater,container,false)
        val view=binding.root
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.text.observe(viewLifecycleOwner){
            binding.textview.text=it
        }
        binding.button.setOnClickListener {
            viewModel._text.value="hell it brooo"
        }




        return view
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }


}