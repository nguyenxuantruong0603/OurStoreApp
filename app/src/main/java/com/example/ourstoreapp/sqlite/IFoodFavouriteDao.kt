package com.example.ourstoreapp.sqlite

import androidx.room.*
import com.example.ourstoreapp.datamodel.food.Food
import com.example.ourstoreapp.datamodel.foodfavourite.FoodFavourite
import kotlinx.coroutines.flow.Flow

@Dao
interface IFoodFavouriteDao {

    @Query("SELECT * FROM foodFavourite")
    fun getAllFoodFavourite(): Flow<List<FoodFavourite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFoodFavourite(food: FoodFavourite)

    @Query("DELETE FROM foodFavourite")
    suspend fun deleteAllFoodFavourite()

    @Delete
    suspend fun deleteFavouriteByKey(favourite: FoodFavourite)
}