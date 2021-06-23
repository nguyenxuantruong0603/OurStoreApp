package com.example.ourstoreapp.view.fragment.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.ourstoreapp.R
import com.example.ourstoreapp.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private lateinit var accountFragmentViewModel: AccountFragmentViewModel
    private lateinit var binding: FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        accountFragmentViewModel =
            AccountFragmentViewModel(
                requireContext(), inflater
            )

        binding.account = accountFragmentViewModel
        return binding.root
    }
}