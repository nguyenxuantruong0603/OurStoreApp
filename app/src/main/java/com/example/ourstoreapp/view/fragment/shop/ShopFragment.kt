package com.example.ourstoreapp.view.fragment.shop

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ourstoreapp.R
import com.example.ourstoreapp.adapter.recycleview.FoodAdapter
import com.example.ourstoreapp.adapter.viewpager.ViewPagerAdapter
import com.example.ourstoreapp.databinding.FragmentShopBinding
import com.example.ourstoreapp.datamodel.Banner
import com.example.ourstoreapp.datamodel.Food
import com.example.ourstoreapp.listener.IClickFoodAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_shop.*
import java.util.*
import kotlin.collections.ArrayList

class ShopFragment : Fragment() {

    private lateinit var shopViewModel: ShopViewModel
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private var timer = Timer()
    private lateinit var binding: FragmentShopBinding
    private var currentItem: Int = 0
    private var totalItem: Int = 0

    private var listBanner = ArrayList<Banner>()
    private var listFood = ArrayList<Food>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)

        shopViewModel =
            ViewModelProvider(this).get(ShopViewModel::class.java)

        shopViewModel.title.observe(viewLifecycleOwner, Observer {
            tvLocation.text = it
        })
        initDataBanner()
        initRecyclerView()

        viewPagerAdapter = ViewPagerAdapter(listBanner)
        binding.vpBannerSale.adapter = viewPagerAdapter
        binding.indicator.setViewPager(binding.vpBannerSale)
        viewPagerAdapter.registerDataSetObserver(binding.indicator.dataSetObserver)

        autoSlideImage()

        return binding.root
    }

    private fun initRecyclerView() {
        var adapter = FoodAdapter(listFood, object : IClickFoodAdapter {
            override fun clickAddToCart(food: Food) {

            }

            override fun clickOpenDetailFood(food: Food) {
                //
            }

        })
    }

    private fun initDataBanner() {
        listBanner.add(Banner(R.drawable.logo1))
        listBanner.add(Banner(R.drawable.logo2))
        listBanner.add(Banner(R.drawable.logo3))
        listBanner.add(Banner(R.drawable.logo4))
        listBanner.add(Banner(R.drawable.logo5))
    }

    private fun autoSlideImage() {
        if (listBanner.isEmpty() || vpBannerSale == null) {
            return
        }

        timer.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    currentItem = binding.vpBannerSale.currentItem
                    totalItem = listBanner.size - 1
                    if (currentItem < totalItem) {
                        currentItem += 1
                        binding.vpBannerSale.currentItem = currentItem
                    } else {
                        binding.vpBannerSale.currentItem = 0
                    }
                }
            }
        }, 500, 3000)

    }


}
