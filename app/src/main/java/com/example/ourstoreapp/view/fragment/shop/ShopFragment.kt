package com.example.ourstoreapp.view.fragment.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ourstoreapp.R
import com.example.ourstoreapp.adapter.ImageSlideShowAdapter
import kotlinx.android.synthetic.main.fragment_shop.*

class ShopFragment : Fragment() {

    private lateinit var shopViewModel: ShopViewModel
    private lateinit var imageSlideShowAdapter: ImageSlideShowAdapter
    private var listImage = intArrayOf(
        R.drawable.logo1,
        R.drawable.logo2,
        R.drawable.logo3,
        R.drawable.logo4,
        R.drawable.logo5
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        shopViewModel =
            ViewModelProvider(this).get(ShopViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_shop, container, false)

        shopViewModel.title.observe(viewLifecycleOwner, Observer {
            tvLocation.text = it
        })

        imageSlideShowAdapter = ImageSlideShowAdapter(requireContext(),listImage)


        //       vpBannerSale.adapter = imageSlideShowAdapter
        listImage.forEach {

            Log.e("LIST", it.toString())



        //vfImage(it)

        }

        return view
    }

//
//    private fun vfImage(image: Int) {
//
//        val imageView = ImageView(context)
//        imageView.setBackgroundResource(image)
//
//    }


}