package com.example.ourstoreapp.datamodel.foodfavourite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foodFavourite")
class FoodFavourite(
    @PrimaryKey @ColumnInfo(name = "foodName") val foodName: String,
    @ColumnInfo(name = "userName") val userName: String,
    @ColumnInfo(name = "foodType") val foodType: String,
    @ColumnInfo(name = "foodPrice") val foodPrice: Double,
    @ColumnInfo(name = "foodDescription") val foodDescription: String,
    @ColumnInfo(name = "foodEvaluate") val foodEvaluate: Int,
    @ColumnInfo(name = "foodWeight") val foodWeight: String,
    @ColumnInfo(name = "foodImage") val foodImage: String
)