package com.example.deliveryapp.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentShoppingCartBinding
import com.example.deliveryapp.presentation.viewmodels.ShoppingCartViewModel

class ShoppingCartFragment : Fragment() {
    private lateinit var viewModel: ShoppingCartViewModel
    private lateinit var binding: FragmentShoppingCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }
}