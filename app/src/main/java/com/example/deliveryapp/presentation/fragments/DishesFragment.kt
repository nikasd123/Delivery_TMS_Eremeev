package com.example.deliveryapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.data.local.DishItem
import com.example.deliveryapp.databinding.FragmentDishesBinding
import com.example.deliveryapp.presentation.adapters.DishItemAdapter

class DishesFragment : Fragment(R.layout.fragment_dishes) {

    private lateinit var binding: FragmentDishesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDishesBinding.bind(view)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        Log.d("AAA", "Dishes fragment have been created")

        observeDishes()
        Log.d("AAA", "all methods of Dishes fragment have been initialized")
    }

    private fun observeDishes() {
        initRecycler()
    }

    private fun initRecycler() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DishItemAdapter(
                items = dishes,
                onItemClickEvent = {
                    findNavController().navigate(
                        R.id.action_dishes_fragment_to_fragment_dishes_list
                    )
                }
            )
        }
    }

    companion object {
        val dishes: List<DishItem> = listOf(
            DishItem(R.drawable.pizza_background, R.drawable.pizza, "PIZZA"),
            DishItem(R.drawable.sushi_background, R.drawable.sushi, "SUSHI"),
            DishItem(R.drawable.drinks_background, R.drawable.cocktail, "DRINKS")
        )
    }
}