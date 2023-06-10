package com.example.deliveryapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        Log.d("AAA", "login fragment have been created")

        initFun()
        Log.d("AAA", "all methods have been initialized")
    }

    private fun initFun() {
        passwordLengthCheck()
    }

    private fun passwordLengthCheck() {
        binding.password.doAfterTextChanged {password ->
            password?.length?.let {
                if (password.length > 8) {
                    binding.loginButton.apply {
                        isEnabled = true
                        navigateToProductsFragment()
                    }
                }
                else binding.loginButton.isEnabled = false
            }
        }
    }

    private fun navigateToProductsFragment() {
        binding.loginButton.setOnClickListener{
            findNavController().navigate(
                R.id.action_registration_fragment_to_products_fragment
            )
        }
    }
}