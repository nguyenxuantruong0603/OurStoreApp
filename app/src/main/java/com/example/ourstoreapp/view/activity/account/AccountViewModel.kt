package com.example.ourstoreapp.view.activity.account

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ourstoreapp.view.activity.HomeActivity

class AccountViewModel(private val context: Context) : ViewModel() {

    var usernameLogin = MutableLiveData<String>()
    var passwordLogin = MutableLiveData<String>()
    var usernameRegister = MutableLiveData<String>()
    var passwordRegister = MutableLiveData<String>()
    var emailRegister = MutableLiveData<String>()

    fun clickLogin() {

        if (usernameLogin.value == null || passwordLogin.value == null || usernameLogin.value == "" || passwordLogin.value == "") {
            Toast.makeText(context, "Không được bỏ trống", Toast.LENGTH_LONG).show()

        } else if (usernameLogin.value == "truongnx" && passwordLogin.value == "Xtruong") {
            Toast.makeText(context, "Đăng nhập thành công ", Toast.LENGTH_LONG).show()
            context.startActivity(Intent(context, HomeActivity::class.java))

        } else {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_LONG).show()
        }
    }


    fun clickLoginGoogle() {
        Toast.makeText(context, "Login Google", Toast.LENGTH_SHORT).show()
    }

    fun clickLoginFacebook() {
        Toast.makeText(context, "Login Facebook", Toast.LENGTH_SHORT).show()
    }

    fun clickSignUp() {

        Log.e("DATA", emailRegister.value.toString())
        if (usernameRegister.value == null || passwordRegister.value == null || emailRegister.value == null) {
            Toast.makeText(context, "Không được bỏ trống", Toast.LENGTH_SHORT).show()
        } else if (usernameRegister.value == "" || passwordRegister.value == "" || emailRegister.value == "") {
            Toast.makeText(context, "Không được bỏ trống", Toast.LENGTH_SHORT).show()
        } else if (passwordRegister.value!!.length < 6) {
            Toast.makeText(context, "Mật khẩu phải hơn 6 ký tự", Toast.LENGTH_SHORT).show()
        } else if (!isValidEmail(emailRegister.value)) {
            Toast.makeText(context, "Email sai định dạng", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Hello Babe", Toast.LENGTH_SHORT).show()
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







