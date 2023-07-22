package com.example.deliveryapp.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentLoginBinding
import com.example.deliveryapp.presentation.viewmodels.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: RegistrationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        initFun()
    }

    private fun initFun() {
        navigateToProductsFragment()
    }

    private fun navigateToProductsFragment() {
        with(binding){
            loginButton.setOnClickListener {
                val login = login.text.toString()
                val password = password.text.toString()

                if (password.length >= 8) {
                    viewModel.registerUser(login, password)
                    findNavController().navigate(R.id.action_registration_fragment_to_products_fragment)
                } else {
                    smallPasswordNotification()
                }
            }
        }
    }

    private fun smallPasswordNotification() {
        binding.loginButton.setOnClickListener {
            Toast.makeText(context, "password less then 8 symbols", Toast.LENGTH_LONG).show()
        }
    }
}