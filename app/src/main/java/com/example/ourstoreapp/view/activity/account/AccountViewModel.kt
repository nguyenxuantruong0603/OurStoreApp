package com.example.ourstoreapp.view.activity.account

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.util.UtilClass.showToast
import com.example.ourstoreapp.view.activity.HomeActivity

class AccountViewModel(val context: Context) : ViewModel() {

    var usernameLogin = MutableLiveData<String>().apply { value = "truongnx" }
    var passwordLogin = MutableLiveData<String>().apply { value = "Xtruong" }
    var usernameRegister = MutableLiveData<String>()
    var passwordRegister = MutableLiveData<String>()
    var emailRegister = MutableLiveData<String>()

    fun clickLogin() {
        if (usernameLogin.value == null || passwordLogin.value == null || usernameLogin.value == "" || passwordLogin.value == "") {
            showToast(context, "Not be empty")

        } else if (usernameLogin.value == "truongnx" && passwordLogin.value == "Xtruong") {
            showToast(context, "Login Success")
            context.startActivity(Intent(context, HomeActivity::class.java))

        } else {
            showToast(context, "Username or password incorrect")
        }
    }
    fun clickLoginGoogle() {
        showToast(context, "Login With Google")
    }

    fun clickLoginFacebook() {
        showToast(context, "Login With Facebook")
    }

    fun clickSignUp() {

        if (usernameRegister.value == null || passwordRegister.value == null || emailRegister.value == null) {
            showToast(context, "Not be empty")
        } else if (usernameRegister.value == "" || passwordRegister.value == "" || emailRegister.value == "") {
            showToast(context, "Not be empty")
        } else if (passwordRegister.value!!.length < 6) {
            showToast(context, "Password must be more than 6 characters")
        } else if (!isValidEmail(emailRegister.value)) {
            showToast(context, "Invalid Email")
        } else {
            showToast(context, "Hello Babe")
        }
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target)
            .matches()
    }
}







