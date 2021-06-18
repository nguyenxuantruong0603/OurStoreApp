package com.example.ourstoreapp.view.fragment.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.ourstoreapp.R
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : Fragment() {
    private lateinit var favouriteViewModel: FavouriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favourite, container, false)

        favouriteViewModel = FavouriteViewModel(requireContext())
        favouriteViewModel.favourite.observe(viewLifecycleOwner, Observer {
            favourite_fragment.text = it
        })
        return view
    }
}