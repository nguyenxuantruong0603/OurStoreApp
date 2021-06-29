package com.example.ourstoreapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ourstoreapp.databinding.ItemFoodFavouriteBinding

class FoodFavouriteAdapter(private val favouriteFoodList: List<String>) :RecyclerView.Adapter<FoodFavouriteAdapter.Holder>() {
    class Holder(binding: ItemFoodFavouriteBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = favouriteFoodList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }
    
}