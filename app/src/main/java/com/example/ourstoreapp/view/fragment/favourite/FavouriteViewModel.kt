package com.example.ourstoreapp.view.fragment.favourite

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.R
import com.example.ourstoreapp.datamodel.Food
import com.example.ourstoreapp.util.UtilClass.showToast

class FavouriteViewModel(private val context: Context) : ViewModel() {

    var favourite = MutableLiveData<String>().apply {
        value = "Favourite fragment"
    }
    var listFoodMutable = MutableLiveData<List<Food>>()
    var foodList: ArrayList<Food> = ArrayList()

    private fun fetchFoodData() {

        foodList.add(
            Food(
                "Apple",
                "Fruit",
                15000,
                "Những quả táo chín đỏ được hái tại vườn của các bác nông dân",
                4,
                "500Gram",
                R.drawable.apple
            )
        )
        foodList.add(
            Food(
                "Orange",
                "Fruit",
                25000,
                "Cam Cao Phong Bắc Ninh thơm ngon ngọt bổ",
                5,
                "1000Gram",
                R.drawable.orange
            )
        )
        foodList.add(
            Food(
                "Banana",
                "Fruit",
                18000,
                "Một nải chuối gồm 24 quả chuối chín vàng ươm và ngọt mát",
                5,
                "750Gram",
                R.drawable.banana
            )
        )
        foodList.add(
            Food(
                "Cherry",
                "Fruit",
                55000,
                "0,5Kg cherry chín đỏ được những bác nông dân chăm sóc kỹ lưỡng và hái khi còn đọng những giọt sương",
                4,
                "500Gram",
                R.drawable.cherry
            )
        )

        listFoodMutable.value = foodList
    }

    fun onClickAddAllToCart() {
        showToast(context, "Add To Cart Successfully")
    }

    init {
        fetchFoodData()
    }
}







