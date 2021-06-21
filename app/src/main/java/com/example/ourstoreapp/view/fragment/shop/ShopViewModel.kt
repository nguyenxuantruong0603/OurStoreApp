package com.example.ourstoreapp.view.fragment.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = "This is shop Fragment"
    }
    val title: LiveData<String> = _title
}