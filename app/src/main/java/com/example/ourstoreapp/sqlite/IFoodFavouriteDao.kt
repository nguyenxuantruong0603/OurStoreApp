package com.example.ourstoreapp.sqlite

import androidx.room.*
import com.example.ourstoreapp.datamodel.food.Food
import com.example.ourstoreapp.datamodel.foodfavourite.FoodFavourite
import kotlinx.coroutines.flow.Flow

@Dao
interface IFoodFavouriteDao {

    @Query("SELECT * FROM foodFavourite")
    fun getAllFood(): Flow<List<Food>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(food: Food)

    @Query("DELETE FROM foodFavourite")
    suspend fun deleteAllFood()

    @Delete
    suspend fun deleteFavouriteByKey(favourite: FoodFavourite)
}