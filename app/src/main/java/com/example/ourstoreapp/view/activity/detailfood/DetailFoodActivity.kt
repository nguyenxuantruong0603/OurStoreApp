package com.example.ourstoreapp.view.activity.detailfood

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.ourstoreapp.R
import com.example.ourstoreapp.databinding.ActivityDetailFoodBinding

class DetailFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val binding: ActivityDetailFoodBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail_food)

        val detailFoodViewModel = DetailFoodViewModel(this)

        binding.toolbarDetailFood.setNavigationIcon(R.drawable.ic_arrow_left)
        binding.toolbarDetailFood.setNavigationOnClickListener { finish() }

        binding.detailFood = detailFoodViewModel
    }
}