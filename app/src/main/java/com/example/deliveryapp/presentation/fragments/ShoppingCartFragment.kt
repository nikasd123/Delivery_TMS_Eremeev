package com.example.deliveryapp.presentation.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentShoppingCartBinding
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.presentation.OnDishItemClickListener
import com.example.deliveryapp.presentation.adapters.ShoppingCartItemAdapter
import com.example.deliveryapp.presentation.viewmodels.ShoppingCartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingCartFragment : Fragment(R.layout.fragment_shopping_cart), OnDishItemClickListener {
    private val viewModel: ShoppingCartViewModel by viewModels()
    private lateinit var binding: FragmentShoppingCartBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShoppingCartBinding.bind(view)

        observeAddToCart()
        initFun()
    }

    private fun initFun() {
        cardNumberLimit()
        successfulPayment()
    }

    private fun observeAddToCart() {
        viewModel.cartItems.observe(viewLifecycleOwner) { cartItems ->
            cartItems?.let { initRecycler(cartItems) }
        }
    }

    private fun initRecycler(cartItems: List<DomainDishes>) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ShoppingCartItemAdapter(
                cartItems = cartItems,
                onDishItemClickListener = this@ShoppingCartFragment
            )
        }
    }

    override fun onDishClicked(dish: DomainDishes) {
        viewModel.removeDishFromCart(dish)
    }

    private fun cardNumberLimit() {
        val cardNumberMaxLength = 19 // 16 digits + 3 spaces
        val cardMMYYMaxLength = 2

        with(binding) {
            cardNumber.doAfterTextChanged { editable ->
                val inputText = editable.toString()

                if (inputText.length > cardNumberMaxLength) {
                    cardNumber.setText(inputText.take(cardNumberMaxLength))
                    cardNumber.setSelection(cardNumberMaxLength)
                } else {
                    val formattedText = inputText.replace(" ", "")
                        .chunked(4)
                        .joinToString(" ")
                    if (formattedText != inputText) {
                        cardNumber.setText(formattedText)
                        cardNumber.setSelection(formattedText.length)
                    }
                }
            }
            listOf(cardMM, cardYY).forEach { editText ->
                editText.doAfterTextChanged { editable ->
                    val inputText = editable.toString()
                    if (inputText.length > cardMMYYMaxLength) {
                        editText.setText(inputText.take(cardMMYYMaxLength))
                        editText.setSelection(cardMMYYMaxLength)
                    }
                }
            }
        }
    }

    private fun successfulPayment() {
        binding.payButton.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setMessage("Order paid")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
    }
}