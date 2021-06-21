package com.example.ourstoreapp.util

import android.content.Context
import android.widget.Toast

object UtilClass {

    fun showToast(context: Context, message: String, timeShow: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, timeShow).show()
    }

}