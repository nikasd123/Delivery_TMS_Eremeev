package com.example.deliveryapp.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.ActivityMainBinding
import com.example.deliveryapp.presentation.viewmodels.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)

        binding.bottomNavView.visibility = View.GONE

        isUserWasRegistered()
        bottomNav()
    }

    private fun bottomNav() {
        binding.bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_category -> {
                    navController.navigate(R.id.dishes_fragment)
                    true
                }

                R.id.navigation_shopping_cart -> {
                    navController.navigate(R.id.fragment_shopping_cart)
                    true
                }

                else -> false
            }
        }
    }

    private fun isUserWasRegistered() {
        val registrationViewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        registrationViewModel.isLoggedIn.observe(this) { isLoggedIn ->
            if (isLoggedIn) {
                binding.bottomNavView.visibility = View.VISIBLE
            } else {
                binding.bottomNavView.visibility = View.GONE
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        val registrationViewModel: RegistrationViewModel =
            ViewModelProvider(this)[RegistrationViewModel::class.java]
        registrationViewModel.isLoggedIn.removeObservers(this)
    }
}