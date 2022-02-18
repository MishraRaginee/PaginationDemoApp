package com.example.ivanassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ivanassignment.R
import com.example.ivanassignment.response.Search


class PagingAdapter(
    val context: Context,
    val onClick:(String?)->Unit) : PagingDataAdapter<Search, PagingAdapter.SearchListViewHolder>(
    DataDifferntiator
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val inflater = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return SearchListViewHolder(inflater)
    }

    inner  class SearchListViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(item: Search) {
            view.findViewById<TextView>(R.id.Name).text = item?.Title
            view.findViewById<TextView>(R.id.year).text = item.Year
            Glide.with(context).load(item?.Poster).into(itemView.findViewById<ImageView>(R.id.imageView))

            view.setOnClickListener {
                onClick.invoke(item.imdbID)
            }

        }

    }
    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }


    }

    object DataDifferntiator : DiffUtil.ItemCallback<Search>() {

        override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }

        override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem == newItem
        }
    }
}