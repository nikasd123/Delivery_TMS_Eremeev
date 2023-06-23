package com.example.deliveryapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentDishesBinding
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.domain.models.DomainDishesList
import com.example.deliveryapp.presentation.adapters.DishItemAdapter
import com.example.deliveryapp.presentation.viewmodels.DishesViewModel
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class DishesFragment : Fragment(R.layout.fragment_dishes) {

    private lateinit var binding: FragmentDishesBinding
    private val viewModel: DishesViewModel by viewModels()
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
        //val dishes = viewModel.dishesList.value ?: DomainDishesList()

        binding.recyclerView.apply {
            adapter = DishItemAdapter(
                items = dishes,
                onItemClickEvent = { view, category ->
                    //findNavController().navigate(R.id.action_dishes_fragment_to_fragment_dishes_list)
                    selectedDishesCategory(view, category)
                }
            )
        }
    }

    private fun selectedDishesCategory(view: View, selectedCategory: String) {
        when (selectedCategory) {
            "PIZZA", "SUSHI", "DRINKS" -> {
                navigationToDishesList(selectedCategory)
            }
        }
    }

    private fun navigationToDishesList(category: String) {
        val action = DishesFragmentDirections.actionDishesFragmentToFragmentDishesList(
            selectedCategory = category
        )
        findNavController().navigate(action)
    }

    companion object {
        val dishes: List<DomainDishes> = listOf(
            DomainDishes(R.drawable.pizza_background, R.drawable.pizza, "PIZZA"),
            DomainDishes(R.drawable.sushi_background, R.drawable.sushi, "SUSHI"),
            DomainDishes(R.drawable.drinks_background, R.drawable.cocktail, "DRINKS")
        )
    }
}