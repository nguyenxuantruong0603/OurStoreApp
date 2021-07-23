package com.example.ourstoreapp.datamodel.foodfavourite

import androidx.annotation.WorkerThread
import com.example.ourstoreapp.sqlite.IFoodFavouriteDao
import kotlinx.coroutines.flow.Flow

class FoodFavouriteRepository(private val foodFavouriteDao: IFoodFavouriteDao) {

    val allFood: Flow<List<FoodFavourite>> = foodFavouriteDao.getAllFoodFavourite()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(foodFavourite: FoodFavourite) {
        foodFavouriteDao.insertFoodFavourite(foodFavourite)
    }
}