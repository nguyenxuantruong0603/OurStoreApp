package com.example.ourstoreapp.view.activity.account

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.ourstoreapp.R
import com.example.ourstoreapp.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val accountViewModel =
            AccountViewModel(this)
        binding.account = accountViewModel

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        layoutRegister.visibility = View.GONE

        tvRegisterNow.setOnClickListener {
            layoutRegister.visibility = View.VISIBLE
            layoutLogin.visibility = View.GONE
        }

        tvLoginNow.setOnClickListener {
            layoutLogin.visibility = View.VISIBLE
            layoutRegister.visibility = View.GONE
        }

//        tvLogin.setOnClickListener {
//            var email: String = edtEmail.text.toString()
//            var password: String = edtPassword.text.toString()
//            Log.e("DATAA2","$email | $password")
//            if (email == "" || password == "") {
//                Toast.makeText(this, "deo dc bo trong", Toast.LENGTH_SHORT).show()
//            } else
//                Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show()
//        }

    }
}