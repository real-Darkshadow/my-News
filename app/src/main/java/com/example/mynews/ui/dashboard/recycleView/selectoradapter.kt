package com.example.mynews.ui.dashboard.recycleView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.R

 class selectoradapter(val context:Context): RecyclerView.Adapter<selectoradapter.vh>() {
    inner class vh(view: View):RecyclerView.ViewHolder(view){
        val chipcard=view.findViewById<CardView>(R.id.chip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        val layout=LayoutInflater.from(context).inflate(R.layout.selectorchips,parent,false)
        return vh(layout)
    }

    override fun getItemCount(): Int =10

    override fun onBindViewHolder(holder: vh, position: Int) {
    }
}