package com.example.ourstoreapp.view.fragment.favourite

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.util.UtilClass.showToast

class FavouriteViewModel(private val context: Context) : ViewModel() {

    var favourite = MutableLiveData<String>().apply {
        value = "Favourite fragment"
    }
    var listFoodMutable = MutableLiveData<List<String>>()
    var arrayList: ArrayList<String> = ArrayList()

    private fun fetchFoodData() {
        for (i in 1..10) {
            arrayList.add(i.toString())
        }
        listFoodMutable.value = arrayList
    }

    fun onClickAddAllToCart() {
        showToast(context, "Add To Cart Successfully")
    }

    init {
        fetchFoodData()
    }
}







