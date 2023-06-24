package com.example.deliveryapp.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentDishesBinding
import com.example.deliveryapp.databinding.FragmentShoppingCartBinding
import com.example.deliveryapp.presentation.viewmodels.ShoppingCartViewModel

class ShoppingCartFragment : Fragment(R.layout.fragment_shopping_cart) {
    private lateinit var viewModel: ShoppingCartViewModel
    private lateinit var binding: FragmentShoppingCartBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShoppingCartBinding.bind(view)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
    }
}