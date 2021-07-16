package com.example.ourstoreapp.view.activity.detailfood

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.datamodel.food.Food
import com.example.ourstoreapp.util.UtilClass.showToast

class DetailFoodViewModel(private val context: Context, val food: Food) : ViewModel() {

    var foodCount = MutableLiveData<Int>().apply { value = 1 }
    var foodPrice = MutableLiveData<Double>().apply { value = food.foodPrice }
    private val foodPriceDefault = MutableLiveData<Double>().apply { value = food.foodPrice }
    val foodName = MutableLiveData<String>().apply { value = food.foodName }
    val foodDes = MutableLiveData<String>().apply { value = food.foodDescription }
    val foodWeight = MutableLiveData<String>().apply { value = food.foodWeight }
    val foodEvaluate = MutableLiveData<Int>().apply { value = food.foodEvaluate }
    val foodImage = MutableLiveData<String>().apply { value = food.foodImage }
    fun onClickAddToBasket() {
        showToast(context, "onClickAddToBasket")
    }

    fun onClickLikeFood() {
        showToast(context, "onClickLikeFood")
    }

    fun onClickUpCountFood() {
        foodCount.value = foodCount.value?.plus(1)
        foodPrice.value = foodPrice.value?.plus(foodPriceDefault.value!!)
    }

    fun onClickDownCountFood() {
        if (foodCount.value!! <= 0) {
            showToast(context, "Số lượng không được nhỏ hơn 0")
        } else {
            foodCount.value = foodCount.value?.minus(1)
            foodPrice.value = foodPrice.value?.minus(foodPriceDefault.value!!)
        }
    }
}