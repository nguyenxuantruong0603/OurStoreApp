package com.example.ourstoreapp.view.fragment.account

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel(private val context: Context) : ViewModel() {
    var text = MutableLiveData<String>().apply {
        value = "Account Fragment"
    }
}