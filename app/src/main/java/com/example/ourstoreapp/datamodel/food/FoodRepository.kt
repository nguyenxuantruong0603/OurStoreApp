package com.example.ourstoreapp.datamodel.food

import androidx.annotation.WorkerThread
import com.example.ourstoreapp.sqlite.IFoodDao
import kotlinx.coroutines.flow.Flow

class FoodRepository(private val foodDao: IFoodDao) {

    val allFood: Flow<List<Food>> = foodDao.getAllFood()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(food: Food) {
        foodDao.insertFood(food)
    }
}