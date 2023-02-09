package com.example.mynews.ui.home.recycleView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.R
import com.example.mynews.ui.dashboard.apidata.countrydata
import com.squareup.picasso.Picasso

class othernewsadapter(val context: Context, val datas: countrydata): RecyclerView.Adapter<othernewsadapter.vhon>() {
    inner class vhon(view:View):RecyclerView.ViewHolder(view){
        val image=view.findViewById<ImageView>(R.id.imageot)
        val title=view.findViewById<TextView>(R.id.titleot)
        val channel=view.findViewById<TextView>(R.id.website)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vhon {
        val lay=LayoutInflater.from(context).inflate(R.layout.othernewsrecycler,parent,false)
        return vhon(lay)
    }

    override fun getItemCount(): Int =10

    override fun onBindViewHolder(holder: vhon, position: Int) {
        if(datas.articles[position].urlToImage!=null){
            Picasso.get().load(datas.articles[position].urlToImage).error(R.drawable.noimg).fit().centerCrop().into(holder.image)
        }
        else{
            holder.image.setImageResource(R.drawable.noimg)
        }
        holder.title.text=datas.articles[position].title
        holder.channel.text=datas.articles[position].author

    }

}