package com.example.ourstoreapp.util

import android.app.Application
import com.example.ourstoreapp.datamodel.food.FoodRepository
import com.example.ourstoreapp.datamodel.foodfavourite.FoodFavouriteRepository
import com.example.ourstoreapp.datamodel.user.UserRepository
import com.example.ourstoreapp.sqlite.OurStoreRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.SupervisorJob

@InternalCoroutinesApi
class CreateDatabase : Application() {

    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val ourStoreDatabase by lazy { OurStoreRoomDatabase.createDatabase(this) }
    val userRepository by lazy { UserRepository(ourStoreDatabase.userDao()) }
    val foodRepository by lazy { FoodRepository(ourStoreDatabase.foodDao()) }
    val foodFavouriteRepository by lazy { FoodFavouriteRepository(ourStoreDatabase.foodFavouriteDao()) }
}