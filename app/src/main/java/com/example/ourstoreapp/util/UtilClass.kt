package com.example.ourstoreapp.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.example.ourstoreapp.R
import com.squareup.picasso.Picasso

object UtilClass {

    fun showToast(context: Context, message: String, timeShow: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, timeShow).show()
    }

    // tự custom 1 thuộc tính imageUrl trong file XML ImageView để làm mọi thứ mình thích với nó.
    // ví dụ bên dưới thì là load ảnh từ URL bằng Picasso
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun picassoLoadImage(view: ImageView, url: String) {
        if (url.isNotEmpty()) {
             Picasso.get().load(url).error(R.drawable.ic_launcher_background).into(view)
        }
    }

}