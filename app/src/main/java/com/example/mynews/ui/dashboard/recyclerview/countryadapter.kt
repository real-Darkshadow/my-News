package com.example.mynews.ui.dashboard.recyclerview

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

class countryadapter(val context:Context, val data: countrydata): RecyclerView.Adapter<countryadapter.viewholder>() {
    inner class viewholder(view: View):RecyclerView.ViewHolder(view){
        val title=view.findViewById<TextView>(R.id.title)
        val image=view.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val lay=LayoutInflater.from(context).inflate(R.layout.horizontalothernees,parent,false)
        return viewholder(lay)
    }

    override fun getItemCount(): Int =data.articles.size

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.title.text=data.articles[position].title
        if(data.articles[position].urlToImage!=null){
            Picasso.get().load(data.articles[position].urlToImage).fit().centerCrop().error(R.drawable.noimg).into(holder.image)
        }
        else{
            holder.image.setImageResource(R.drawable.noimg)
        }
    }
}