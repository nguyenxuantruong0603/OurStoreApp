package com.example.ourstoreapp.sqlite

import androidx.room.*
import com.example.ourstoreapp.datamodel.food.Food
import kotlinx.coroutines.flow.Flow

@Dao
interface IFoodDao {

//    @Query("SELECT * FROM food ORDER BY foodPrice ASC")
//    fun getListUp(): List<Food>

    @Query("SELECT * FROM food")
    fun getAllFood(): Flow<List<Food>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(food: Food)

    @Query("DELETE FROM food")
    suspend fun deleteAllFood()

    @Delete
    suspend fun deleteFoodByKey(food: Food)

}