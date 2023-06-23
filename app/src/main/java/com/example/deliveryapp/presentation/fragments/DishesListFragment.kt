package com.example.deliveryapp.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.deliveryapp.R

class DishesListFragment : Fragment(R.layout.fragment_dishes_list) {
    private val args: DishesListFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedCategory = args.selectedCategory
    }
}