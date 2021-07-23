package com.example.ourstoreapp.sqlite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ourstoreapp.datamodel.food.Food
import com.example.ourstoreapp.datamodel.foodfavourite.FoodFavourite
import com.example.ourstoreapp.datamodel.user.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch

@Database(
    entities = [(Food::class), (FoodFavourite::class), (User::class)],
    version = 1,
    exportSchema = false
)
abstract class OurStoreRoomDatabase : RoomDatabase() {

    abstract fun foodDao(): IFoodDao
    abstract fun foodFavouriteDao(): IFoodFavouriteDao
    abstract fun userDao(): IUserDao

    companion object {

        private var INSTANCE: OurStoreRoomDatabase? = null

        @InternalCoroutinesApi
        fun createDatabase(
            context: Context,
            scope: CoroutineScope
        ): OurStoreRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OurStoreRoomDatabase::class.java,
                    "food_database"
                )
                    .addCallback(OurStoreDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                //return instance
                instance
            }
        }

    }

    private class OurStoreDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.foodDao())
                }
            }
        }

        suspend fun populateDatabase(foodDao: IFoodDao) {
            // Delete all content here.
            foodDao.deleteAllFood()

            // Add sample words.
            val food = Food(
                "Apple",
                "Fruit",
                4.99,
                "Những quả táo chín đỏ được hái tại vườn của các bác nông dân",
                5,
                "500Gram",
                "https://e7.pngegg.com/pngimages/601/476/png-clipart-grape-grape-thumbnail.png"
            )
            foodDao.insertFood(food)

            // TODO: Add your own words!
        }
    }
}
