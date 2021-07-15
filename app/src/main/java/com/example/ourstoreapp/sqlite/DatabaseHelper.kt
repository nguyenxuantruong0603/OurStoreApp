package com.example.ourstoreapp.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ourstoreapp.sqlite.DatabaseHelper.DatabaseTable.CREATE_FOOD
import com.example.ourstoreapp.sqlite.DatabaseHelper.DatabaseTable.CREATE_FOOD_FAVOURITE
import com.example.ourstoreapp.sqlite.DatabaseHelper.DatabaseTable.CREATE_USER

class DatabaseHelper(
    context: Context?,
    name: String = "OUR_STORE.DB",
    factory: SQLiteDatabase.CursorFactory?,
    version: Int = 1
) : SQLiteOpenHelper(context, name, factory, version) {

    object DatabaseTable {

        // Table User
        val TABLE_USER: String = "TABLE_USER"
        val FULL_NAME: String = "fullname"
        val ID_USER: String = "idUser"
        val USER_NAME: String = "username"
        val PASS_WORD: String = "password"

        // Table Food
        val TABLE_FOOD: String = "TABLE_FOOD"
        val ID_FOOD: String = "idFood"
        val FOOD_NAME: String = "foodName"
        val FOOD_TYPE: String = "foodType"
        val FOOD_PRICE: String = "foodPrice"
        val FOOD_DESC: String = "foodDescription"
        val FOOD_EVALUATE: String = "foodEvaluate"
        val FOOD_WEIGHT: String = "foodWeight"
        val FOOD_IMAGE: String = "foodImage"

        // Table Food Favourite
        val TABLE_FOOD_FAVOURITE: String = "TABLE_FOOD_FAVOURITE"
        val ID_FOOD_FAVOURITE: String = "idFoodFavourite"
        val FOOD_NAME_FAVOURITE: String = "foodNameFavourite"
        val FOOD_TYPE_FAVOURITE: String = "foodTypeFavourite"
        val FOOD_PRICE_FAVOURITE: String = "foodPriceFavourite"
        val FOOD_DESC_FAVOURITE: String = "foodDescriptionFavourite"
        val FOOD_EVALUATE_FAVOURITE: String = "foodEvaluateFavourite"
        val FOOD_WEIGHT_FAVOURITE: String = "foodWeightFavourite"
        val FOOD_IMAGE_FAVOURITE: String = "foodImageFavourite"

        // Table CART
        val TABLE_CART: String = "TABLE_CART"
        val CART_USER_NAME: String = "cartUserName"
        val CART_NAME: String = "cartName"
        val CART_TYPE: String = "cartType"
        val CART_PRICE: String = "cartPrice"
        val CART_DESC: String = "cartDescription"
        val CART_EVALUATE: String = "cartEvaluate"
        val CART_WEIGHT: String = "cartWeight"
        val CART_IMAGE: String = "cartImage"


        val CREATE_USER: String =
            "create table" + TABLE_USER + "(" + ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FULL_NAME + " TEXT, " + USER_NAME + " TEXT NOT NULL, " + PASS_WORD + " TEXT NOT NULL);"

        val CREATE_FOOD: String =
            "create table" + TABLE_FOOD + "(" + ID_FOOD + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FOOD_NAME + " TEXT, " + FOOD_TYPE + " TEXT, " + FOOD_PRICE + " REAL, " + FOOD_DESC + " TEXT, " +
                    FOOD_EVALUATE + " INTEGER, " + FOOD_WEIGHT + " TEXT, " + FOOD_IMAGE + " TEXT);"
        val CREATE_FOOD_FAVOURITE: String =
            "create table" + TABLE_FOOD_FAVOURITE + "(" + ID_FOOD_FAVOURITE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FOOD_NAME_FAVOURITE + " TEXT, " + FOOD_TYPE_FAVOURITE + " TEXT, " + FOOD_PRICE_FAVOURITE + " REAL, " + FOOD_DESC_FAVOURITE + " TEXT, " +
                    FOOD_EVALUATE_FAVOURITE + " INTEGER, " + FOOD_WEIGHT_FAVOURITE + " TEXT, " + FOOD_IMAGE_FAVOURITE + " TEXT);"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_USER)
        db?.execSQL(CREATE_FOOD)
        db?.execSQL(CREATE_FOOD_FAVOURITE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}