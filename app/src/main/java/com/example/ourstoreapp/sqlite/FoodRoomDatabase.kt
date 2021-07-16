package com.example.ourstoreapp.sqlite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ourstoreapp.datamodel.food.Food
import com.example.ourstoreapp.datamodel.foodfavourite.FoodFavourite
import com.example.ourstoreapp.datamodel.User
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [(Food::class), (FoodFavourite::class), (User::class)],
    version = 1,
    exportSchema = false
)
abstract class FoodRoomDatabase : RoomDatabase() {

    abstract fun foodDao(): IFoodDao
    abstract fun foodFavouriteDao(): IFoodFavouriteDao
    abstract fun userDao(): IUserDao

    companion object {

        private var INSTANCE: FoodRoomDatabase? = null

        @InternalCoroutinesApi
        fun createDatabase(context: Context): FoodRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodRoomDatabase::class.java,
                    "food_database"
                ).build()

                INSTANCE = instance
                //return instance
                instance
            }
        }

    }
}
