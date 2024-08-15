package com.example.clientbook.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clientbook.databinding.RowBestSaleBinding
import com.example.clientbook.databinding.RowClientBinding
import com.example.clientbook.model.Carousel
import com.example.clientbook.model.Product

class BestSaleAdapter : RecyclerView.Adapter<BestSaleAdapter.BestSaleViewHolder>() {

    private val listProduct: ArrayList<Product> = ArrayList()
    private lateinit var context : Context
    
    fun updateList(listItems : List<Product>?){
        this.listProduct.clear()
        this.listProduct.addAll(listItems!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): BestSaleAdapter.BestSaleViewHolder {
        val itemBinding: RowBestSaleBinding = RowBestSaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestSaleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BestSaleAdapter.BestSaleViewHolder, position: Int) {
        val currentItem = listProduct[position]
        holder.bindData(currentItem)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    inner class BestSaleViewHolder(binding: RowBestSaleBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        var tvProductName: TextView = binding.tvProductName

        fun bindData(item: Product){
            tvProductName.setText(item.name)
        }
    }
}