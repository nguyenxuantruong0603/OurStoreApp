package com.example.ourstoreapp.view.fragment.favourite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.ourstoreapp.R
import com.example.ourstoreapp.adapter.recycleview.FoodFavouriteAdapter
import com.example.ourstoreapp.databinding.FragmentFavouriteBinding
import com.example.ourstoreapp.datamodel.Food
import com.example.ourstoreapp.listener.IClickOpenDetailFood
import com.example.ourstoreapp.view.activity.detailfood.DetailFoodActivity

class FavouriteFragment : Fragment() {
    private lateinit var favouriteViewModel: FavouriteViewModel
    private lateinit var foodFavouriteAdapter: FoodFavouriteAdapter

    var foodList: ArrayList<Food> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentFavouriteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false)

        foodFavouriteAdapter = FoodFavouriteAdapter(foodList, object : IClickOpenDetailFood {
            override fun openDetail(food: Food) {
                val intent = Intent(context, DetailFoodActivity::class.java)
//                intent.putExtra("FOODNAME", food.foodName)
//                intent.putExtra("FOODPRICE", food.foodPrice)
//                intent.putExtra("FOODDES", food.foodDescription)
//                intent.putExtra("FOODWEIGHT", food.foodWeight)
//                intent.putExtra("FOODIMAGE", food.foodImage)
                intent.putExtra("FOOD_DATA", food)
                startActivity(intent)
            }

        })

        val dividerItemDecoration =
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rcFavourite.adapter = foodFavouriteAdapter
        binding.rcFavourite.setHasFixedSize(true)

        binding.rcFavourite.addItemDecoration(dividerItemDecoration)

        favouriteViewModel = FavouriteViewModel(requireContext())
        favouriteViewModel.listFoodMutable.observe(viewLifecycleOwner, Observer {

            foodList.addAll(it)
            foodFavouriteAdapter.notifyDataSetChanged()

        })

        binding.favourite = favouriteViewModel
        return binding.root
    }
}