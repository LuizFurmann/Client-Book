package com.example.clientbook.view.cart

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clientbook.R
import com.example.clientbook.databinding.RowProductCartBinding
import com.example.clientbook.model.Product
import com.example.clientbook.view.product.ProductDetailsActivity

class ProductCartAdapter : RecyclerView.Adapter<ProductCartAdapter.BestSaleViewHolder>() {

    private val listProduct: ArrayList<Product> = ArrayList()
    private lateinit var context : Context

    fun updateList(listItems : List<Product>?){
        this.listProduct.clear()
        this.listProduct.addAll(listItems!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ProductCartAdapter.BestSaleViewHolder {
        val itemBinding: RowProductCartBinding = RowProductCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestSaleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductCartAdapter.BestSaleViewHolder, position: Int) {
        var currentItem = listProduct[position]
        holder.bindData(currentItem)

        holder.itemView.setOnClickListener {
            Intent(holder.itemView.context, ProductDetailsActivity::class.java).also{
                it.putExtra("Product", currentItem)
                holder.itemView.context.startActivity(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    inner class BestSaleViewHolder(binding: RowProductCartBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        var tvProductName: TextView = binding.tvProductName
        var tvPrice: TextView = binding.tvProductPrice

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