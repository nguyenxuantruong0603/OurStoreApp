package com.example.ourstoreapp.view.fragment.shop

import androidx.lifecycle.*
import com.example.ourstoreapp.datamodel.food.Food
import com.example.ourstoreapp.datamodel.food.FoodRepository
import kotlinx.coroutines.launch

class ShopViewModel(private val foodRepository: FoodRepository) : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = "Liên Bạt - Ứng Hòa - Hà Nội"
    }
    val title: LiveData<String> = _title
    val listFood: LiveData<List<Food>> = foodRepository.allFood.asLiveData()

    fun insertFood(food: Food) = viewModelScope.launch { foodRepository.insert(food) }
}