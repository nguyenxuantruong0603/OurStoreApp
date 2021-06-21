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
            showToast(context, "Không được bỏ trống")

        } else if (usernameLogin.value == "truongnx" && passwordLogin.value == "Xtruong") {
            showToast(context, "Đăng nhập thành công")
            context.startActivity(Intent(context, HomeActivity::class.java))

        } else {
            showToast(context, "Tài khoản hoặc mật khẩu không đúng")
        }
    }
    fun clickLoginGoogle() {
        showToast(context, "Login With Google")
    }

    fun clickLoginFacebook() {
        showToast(context, "Login With Facebook")
    }

    fun clickSignUp() {

        Log.e("DATA", emailRegister.value.toString())
        if (usernameRegister.value == null || passwordRegister.value == null || emailRegister.value == null) {
            showToast(context, "Không được bỏ trống")
        } else if (usernameRegister.value == "" || passwordRegister.value == "" || emailRegister.value == "") {
            showToast(context, "Không được bỏ trống")
        } else if (passwordRegister.value!!.length < 6) {
            showToast(context, "Mật khẩu phải hơn 6 ký tự")
        } else if (!isValidEmail(emailRegister.value)) {
            showToast(context, "Email sai định dạng")
        } else {
            showToast(context, "Hello Babe")
        }
    }

    /*
    @BindingAdapter("app:goneUnless")
    fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
    }
    */
    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target)
            .matches()
    }
}







