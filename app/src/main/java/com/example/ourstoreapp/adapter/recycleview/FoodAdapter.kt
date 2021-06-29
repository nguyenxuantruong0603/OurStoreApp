package com.example.ourstoreapp.adapter.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ourstoreapp.databinding.ItemFoodBinding
import com.example.ourstoreapp.datamodel.Food
import com.example.ourstoreapp.listener.IClickFoodAdapter

class FoodAdapter(
    private val listFood: List<Food>,
    val iClickFoodAdapter: IClickFoodAdapter
) : RecyclerView.Adapter<FoodAdapter.Holder>() {


    inner class Holder(var binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(foodValue: Food) {
            binding.food = foodValue
            binding.clickFood = iClickFoodAdapter
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount(): Int = listFood.size
}