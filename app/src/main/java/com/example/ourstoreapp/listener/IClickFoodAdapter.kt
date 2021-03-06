package com.example.ourstoreapp.listener

import com.example.ourstoreapp.datamodel.food.Food

interface IClickFoodAdapter {
    fun clickAddToCart(food: Food)
    fun clickOpenDetailFood(food: Food)
}