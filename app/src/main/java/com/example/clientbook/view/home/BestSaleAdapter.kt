package com.example.clientbook.view.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clientbook.R
import com.example.clientbook.databinding.RowBestSaleBinding
import com.example.clientbook.model.Product
import com.example.clientbook.view.product.ProductDetailsActivity

class BestSaleAdapter : RecyclerView.Adapter<BestSaleAdapter.BestSaleViewHolder>() {

    private val listProduct: ArrayList<Product> = ArrayList()
    
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
        var currentItem = listProduct[position]
        holder.bindData(currentItem)

        holder.itemView.setOnClickListener {
            Intent(holder.itemView.context, ProductDetailsActivity::class.java).also{
                it.putExtra("Product", currentItem)
                holder.itemView.context.startActivity(it)
            }
        }



        if(currentItem.favorite){
            holder.btnFavorite.setImageResource(R.drawable.ic_favorite_false)
            currentItem.favorite = false
        }else{
            holder.btnFavorite.setImageResource(R.drawable.ic_favorite_true)
            currentItem.favorite = true
        }

        holder.btnFavorite.setOnClickListener {
            if(currentItem.favorite){
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_false)
                currentItem.favorite = false
            }else{
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_true)
                currentItem.favorite = true
            }
        }
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    inner class BestSaleViewHolder(binding: RowBestSaleBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        var tvProductName: TextView = binding.tvProductName
        var btnFavorite: ImageView = binding.btnFavorite
        var tvPrice : TextView = binding.tvPrice
        var image : ImageView = binding.imgProduct

        fun bindData(item: Product){
            tvProductName.setText(item.name)
            tvPrice.setText("R$${item.price}")

            if(item.name == "Camiseta feminina"){
                image.setBackgroundResource(R.drawable.cloth1)
            }else if(item.name == "Camiseta masculina"){
                image.setBackgroundResource(R.drawable.cloth2)
            }else if(item.name == "Chapéu de praia"){
                image.setBackgroundResource(R.drawable.cloth3)
            }else if(item.name == "Calça jeans feminina"){
                image.setBackgroundResource(R.drawable.cloth4)
            } else if(item.name == "Camisa masculina"){
                image.setBackgroundResource(R.drawable.cloth5)
            } else if(item.name == "Camisa masculina cinza"){
                image.setBackgroundResource(R.drawable.cloth6)
            }
        }
    }
}