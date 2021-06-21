package com.example.ourstoreapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.ourstoreapp.R


class ImageSlideShowAdapter(private val context: Context, private val imageList: IntArray) :
    PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val sliderLayout: View =
            LayoutInflater.from(context).inflate(R.layout.item_slide_show, null)
        val imgBannerSale: ImageView = sliderLayout.findViewById(R.id.imgBannerSale)
        imgBannerSale.setImageResource(
            imageList[position]
        )
        container.addView(sliderLayout)
        return sliderLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }
}