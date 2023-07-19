package com.example.deliveryapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentShoppingCartBinding
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.presentation.adapters.ShoppingCartItemAdapter
import com.example.deliveryapp.presentation.viewmodels.ShoppingCartViewModel

class ShoppingCartFragment : Fragment(R.layout.fragment_shopping_cart) {
    private val viewModel: ShoppingCartViewModel by viewModels()
    private lateinit var binding: FragmentShoppingCartBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShoppingCartBinding.bind(view)

        observeAddToCart()
//        viewModel = ViewModelProvider(requireActivity())[ShoppingCartViewModel::class.java]
//        viewModel.
    }

    private fun observeAddToCart() {
        viewModel.cartItems.observe(viewLifecycleOwner) {cartItems ->
            initRecycler(cartItems)
        }
    }

    private fun initRecycler(cartItems: List<DomainDishes>) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ShoppingCartItemAdapter(cartItems)
        }
    }
}