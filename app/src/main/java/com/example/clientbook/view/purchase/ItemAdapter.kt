package com.example.clientbook.view.purchase

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clientbook.databinding.RowClientBinding
import com.example.clientbook.model.Product
import java.util.Locale

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.UserViewHolder>(), Filterable {
    private val listItems: MutableList<Product>? = ArrayList()
    private val listItemsFiltered: MutableList<Product> = ArrayList()

    var context: Context? = null

    fun setListItems(listItems: List<Product>?) {
        if (this.listItems!!.size > 0) {
            this.listItems.clear()
            listItemsFiltered.clear()
        }
        this.listItems.addAll(listItems!!)
        listItemsFiltered.addAll(listItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemBinding: RowClientBinding =
            RowClientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentPosition = listItems!![position]

        holder.tvClientName.text = currentPosition.name
    }

    override fun getItemCount(): Int {
        return listItems?.size ?: 0
    }

    override fun getFilter(): Filter {
        return FilterUser
    }

    private val FilterUser: Filter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val searchText = charSequence.toString().lowercase(Locale.getDefault())
            val newList: MutableList<Product> = ArrayList()
            if (searchText.length == 0 || searchText.isEmpty()) {
                newList.addAll(listItemsFiltered)
            } else {
                for (item in listItemsFiltered) {
                    if (item.name.lowercase(Locale.getDefault()).contains(searchText)) {
                        newList.add(item)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = newList
            return filterResults
        }

        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            listItems!!.clear()
            listItems.addAll((filterResults.values as Collection<Product>))
            notifyDataSetChanged()
        }
    }

    inner class UserViewHolder(binding: RowClientBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {
        var tvClientName: TextView = binding.tvClientName
    }
}
