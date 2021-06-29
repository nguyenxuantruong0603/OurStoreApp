package com.example.ourstoreapp.view.activity.detailfood

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.util.UtilClass.showToast

class DetailFoodViewModel(private val context: Context) : ViewModel() {

    var countFood = MutableLiveData<Int>().apply { value = 1 }
    var priceFood = MutableLiveData<Int>().apply { value = 2 }

    fun onClickAddToBasket() {
        showToast(context, "onClickAddToBasket")
    }

    fun onClickLikeFood() {
        showToast(context, "onClickLikeFood")
    }

    fun onClickUpCountFood() {
        countFood.value = countFood.value?.plus(1)
        showToast(context, "onClickUpCountFood" + countFood.value)
    }

    fun onClickDownCountFood() {
        countFood.value = countFood.value?.minus(1)
        showToast(context, "onClickDownCountFood" + countFood.value)
    }
}