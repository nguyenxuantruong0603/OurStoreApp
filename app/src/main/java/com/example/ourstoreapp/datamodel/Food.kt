package com.example.ourstoreapp.datamodel

import java.io.Serializable

class Food(
    val foodName: String,
    val foodType: String,
    val foodPrice: Double,
    val foodDescription: String,
    val foodEvaluate: Int,
    val foodWeight: String,
    val foodImage: String
) : Serializable