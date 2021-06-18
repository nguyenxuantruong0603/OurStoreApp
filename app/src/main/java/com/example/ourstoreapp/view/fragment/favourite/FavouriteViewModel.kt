package com.example.ourstoreapp.view.fragment.favourite

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavouriteViewModel(private val context: Context) : ViewModel() {

    var favourite = MutableLiveData<String>().apply {
        value = "Favourite fragment"
    }

}