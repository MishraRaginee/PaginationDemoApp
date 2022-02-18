package com.example.paginationdemoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ivanassignment.R
import com.example.ivanassignment.response.Search

class SimpleAdapter(val context: Context,val list: List<Search>) : RecyclerView.Adapter<SimpleAdapter.MyViewHolder>(){
    inner class  MyViewHolder(val view:View):RecyclerView.ViewHolder(view){
        fun bind(item: Search) {
            view.findViewById<TextView>(R.id.Name).text = item?.Title
            view.findViewById<TextView>(R.id.year).text = item.Year
            Glide.with(context).load(item?.Poster).into(itemView.findViewById<ImageView>(R.id.imageView))

            view.setOnClickListener {

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int =list.size
}