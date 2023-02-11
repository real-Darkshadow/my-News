package com.example.mynews.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews.databinding.FragmentNotificationsBinding
import com.example.mynews.room.database
import com.example.mynews.ui.notifications.recycler.save_adapter

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val db=database.getDatabase(requireContext())
        val k=db.dao().getnote()
        binding.saverec.adapter=save_adapter(requireContext(),k)
        binding.saverec.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}