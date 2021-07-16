package com.example.ourstoreapp.view.fragment.favourite

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.datamodel.food.Food
import com.example.ourstoreapp.util.UtilClass.showToast

class FavouriteViewModel(private val context: Context) : ViewModel() {

    var favourite = MutableLiveData<String>().apply {
        value = "Favourite fragment"
    }
    var listFoodMutable = MutableLiveData<ArrayList<Food>>()
    var foodList: ArrayList<Food> = ArrayList()

    private fun fetchFoodData() {

        foodList.add(
            Food(
                "Apple",
                "Fruit",
                4.99,
                "Những quả táo chín đỏ được hái tại vườn của các bác nông dân",
                4,
                "500Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Orange",
                "Fruit",
                3.25,
                "Cam Cao Phong Bắc Ninh thơm ngon ngọt bổ",
                5,
                "1000Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Banana",
                "Fruit",
                2.25,
                "Một nải chuối gồm 24 quả chuối chín vàng ươm và ngọt mát",
                5,
                "750Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Cherry",
                "Fruit",
                7.55,
                "0,5Kg cherry chín đỏ được những bác nông dân chăm sóc kỹ lưỡng và hái khi còn đọng những giọt sương",
                4,
                "500Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )

        foodList.add(
            Food(
                "Apple",
                "Fruit",
                4.99,
                "Những quả táo chín đỏ được hái tại vườn của các bác nông dân",
                4,
                "500Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Orange",
                "Fruit",
                3.25,
                "Cam Cao Phong Bắc Ninh thơm ngon ngọt bổ",
                5,
                "1000Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Banana",
                "Fruit",
                2.25,
                "Một nải chuối gồm 24 quả chuối chín vàng ươm và ngọt mát",
                5,
                "750Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Cherry",
                "Fruit",
                7.55,
                "0,5Kg cherry chín đỏ được những bác nông dân chăm sóc kỹ lưỡng và hái khi còn đọng những giọt sương",
                4,
                "500Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )

        foodList.add(
            Food(
                "Apple",
                "Fruit",
                4.99,
                "Những quả táo chín đỏ được hái tại vườn của các bác nông dân",
                4,
                "500Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Orange",
                "Fruit",
                3.25,
                "Cam Cao Phong Bắc Ninh thơm ngon ngọt bổ",
                5,
                "1000Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Banana",
                "Fruit",
                2.25,
                "Một nải chuối gồm 24 quả chuối chín vàng ươm và ngọt mát",
                5,
                "750Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
        )
        foodList.add(
            Food(
                "Cherry",
                "Fruit",
                7.55,
                "0,5Kg cherry chín đỏ được những bác nông dân chăm sóc kỹ lưỡng và hái khi còn đọng những giọt sương",
                4,
                "500Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
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







