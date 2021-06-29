package com.example.ourstoreapp.view.fragment.favourite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ourstoreapp.R
import com.example.ourstoreapp.adapter.FoodFavouriteAdapter
import com.example.ourstoreapp.databinding.FragmentFavouriteBinding
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : Fragment() {
    private lateinit var favouriteViewModel: FavouriteViewModel
    private lateinit var foodFavouriteAdapter: FoodFavouriteAdapter
    private var listFood = listOf(
        "A",
        "B",
        "C"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFavouriteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false)

        foodFavouriteAdapter = FoodFavouriteAdapter(listFood)

        favouriteViewModel = FavouriteViewModel(requireContext())
        favouriteViewModel.listFoodMutable.observe(viewLifecycleOwner, Observer {

            Log.e("DATA",it.toString() +" | " + it.size)
//            listFood = it
//
//            foodFavouriteAdapter.notifyDataSetChanged()

//            val dividerItemDecoration =
//                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
//            binding.rcFavourite.adapter = foodFavouriteAdapter
//            binding.rcFavourite.setHasFixedSize(true)
//
//            binding.rcFavourite.addItemDecoration(dividerItemDecoration)

        })

        binding.favourite = favouriteViewModel
        return binding.root
    }
}