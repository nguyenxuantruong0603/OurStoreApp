package com.example.ourstoreapp.adapter.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ourstoreapp.databinding.ItemFoodFavouriteBinding
import com.example.ourstoreapp.datamodel.Food
import com.example.ourstoreapp.listener.IClickOpenDetailFood

class FoodFavouriteAdapter(
    private val favouriteFoodList: List<Food>,
    private val iClickOpenDetailFood: IClickOpenDetailFood
) :
    RecyclerView.Adapter<FoodFavouriteAdapter.Holder>() {

    class Holder(var binding: ItemFoodFavouriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binFavourite(foodValue: Food, iClickOpenDetailFood: IClickOpenDetailFood) {
            binding.food = foodValue
            itemView.setOnClickListener { iClickOpenDetailFood.openDetail(foodValue) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        return Holder(
            ItemFoodFavouriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = favouriteFoodList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binFavourite(favouriteFoodList[position], iClickOpenDetailFood)

    }

}