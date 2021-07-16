package com.example.ourstoreapp.datamodel.food

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "food")
class Food(
    @PrimaryKey @ColumnInfo(name = "foodName") val foodName: String,
    @ColumnInfo(name = "foodType") val foodType: String,
    @ColumnInfo(name = "foodPrice") val foodPrice: Double,
    @ColumnInfo(name = "foodDescription") val foodDescription: String,
    @ColumnInfo(name = "foodEvaluate") val foodEvaluate: Int,
    @ColumnInfo(name = "foodWeight") val foodWeight: String,
    @ColumnInfo(name = "foodImage") val foodImage: String
) : Serializable