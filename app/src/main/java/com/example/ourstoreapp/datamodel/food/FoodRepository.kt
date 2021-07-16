package com.example.ourstoreapp.datamodel.food

import com.example.ourstoreapp.sqlite.IFoodDao
import java.util.concurrent.Flow

class FoodRepository(foodDao: IFoodDao) {

    val allFood: Flow<List<Food>> = foodDao.getAllFood()
}