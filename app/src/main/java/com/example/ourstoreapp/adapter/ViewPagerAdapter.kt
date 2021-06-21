package com.example.ourstoreapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.ourstoreapp.R
import com.example.ourstoreapp.datamodel.Banner

class ViewPagerAdapter(private val imageList: List<Banner>) :
    PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view: View =
            LayoutInflater.from(container.context).inflate(R.layout.item_slide_show, null)
        val imgBannerSale: ImageView = view.findViewById(R.id.imgBannerSale)
        imgBannerSale.setImageResource(
            imageList[position].image
        )
        container.addView(view)
        return view
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