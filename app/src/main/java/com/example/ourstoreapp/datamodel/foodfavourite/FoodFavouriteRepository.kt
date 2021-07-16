package com.example.ourstoreapp.datamodel.foodfavourite

import com.example.ourstoreapp.sqlite.IFoodFavouriteDao
import java.util.concurrent.Flow

class FoodFavouriteRepository(foodFavouriteDao: IFoodFavouriteDao) {

    val allFood: Flow<List<FoodFavourite>> = foodFavouriteDao.getAllFood()
}