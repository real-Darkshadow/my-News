package com.example.mynews.ui.home.recycleView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.R
import com.example.mynews.ui.dashboard.apidata.countrydata

class othernewsadapter(val context: Context, datas: countrydata): RecyclerView.Adapter<othernewsadapter.vhon>() {
    inner class vhon(view:View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vhon {
        val lay=LayoutInflater.from(context).inflate(R.layout.othernewsrecycler,parent,false)
        return vhon(lay)
    }

    override fun getItemCount(): Int =10

    override fun onBindViewHolder(holder: vhon, position: Int) {

    }

}