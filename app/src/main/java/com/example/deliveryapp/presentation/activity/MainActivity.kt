package com.example.deliveryapp.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        Log.d("AAA", "activity creating...")
        bottomNav()
        Log.d("AAA", "Activity created successful")
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
}