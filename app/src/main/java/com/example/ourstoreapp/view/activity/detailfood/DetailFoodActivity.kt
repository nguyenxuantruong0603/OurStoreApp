package com.example.ourstoreapp.view.activity.detailfood

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.ourstoreapp.R
import com.example.ourstoreapp.databinding.ActivityDetailFoodBinding
import com.example.ourstoreapp.datamodel.Food

class DetailFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        val food = intent.getSerializableExtra("FOOD_DATA")
        val binding: ActivityDetailFoodBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail_food)

        val detailFoodViewModel = DetailFoodViewModel(this, food as Food)
        detailFoodViewModel.foodCount.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })

        detailFoodViewModel.foodPrice.observe(this, Observer {
            binding.tvPrice.text = String.format("$ %.2f", it)
        })



        binding.toolbarDetailFood.setNavigationIcon(R.drawable.ic_arrow_left)
        binding.toolbarDetailFood.setNavigationOnClickListener { finish() }

        binding.detailFood = detailFoodViewModel
    }
}