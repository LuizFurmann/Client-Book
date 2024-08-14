package com.example.clientbook.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clientbook.R
import com.example.clientbook.databinding.RowCarouselBinding
import com.example.clientbook.model.Carousel

class CarouselAdapter : ListAdapter<Carousel, CarouselAdapter.ViewHolder>(DiffCallback()){

    class DiffCallback : DiffUtil.ItemCallback<Carousel>(){
        override fun areItemsTheSame(oldItem: Carousel, newItem: Carousel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Carousel, newItem: Carousel): Boolean {
            return oldItem == newItem
        }

    }
    class ViewHolder(iteView: View): RecyclerView.ViewHolder(iteView){
        private val imageView = iteView.findViewById<ImageView>(R.id.imageView)

        fun bindData(item: Carousel){
            Glide.with(itemView)
                .load(item.thumbnail)
                .into(imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_carousel,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageItem = getItem(position)
        holder.bindData(imageItem)
    }
}