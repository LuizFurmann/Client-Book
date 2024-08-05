package com.example.clientbook.view.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clientbook.databinding.RowClientBinding;
import com.example.clientbook.model.Client;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.UserViewHolder>implements Filterable {

    private List<Client> listItems = new ArrayList<>();
    private List<Client> listItemsFiltered = new ArrayList<>();

    Context context;

    public void setListItems(List<Client> listItems){
        if( this.listItems.size()>0){
            this.listItems.clear();
            this.listItemsFiltered.clear();
        }
        this.listItems.addAll(listItems);
        this.listItemsFiltered.addAll(listItems);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowClientBinding itemBinding = RowClientBinding .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Client currentPosition = listItems.get(position);

        holder.tvClientName.setText(currentPosition.getName());
    }

    @Override
    public int getItemCount() {
        if(listItems == null)
            return 0;
        else
            return listItems.size();
    }

    @Override
    public Filter getFilter() {
        return FilterUser;
    }
    private Filter FilterUser = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String searchText = charSequence.toString().toLowerCase();
            List<Client>newList = new ArrayList<>();
            if(searchText.length()==0 || searchText.isEmpty()){
                newList.addAll(listItemsFiltered);
            }else{
                for(Client item: listItemsFiltered){
                    if(item.getName().toLowerCase().contains(searchText)){
                        newList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = newList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            listItems.clear();
            listItems.addAll((Collection<? extends Client>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvClientName;

        public UserViewHolder(@NonNull RowClientBinding binding) {
            super(binding.getRoot());
            tvClientName = binding.tvClientName;
        }
    }
}
