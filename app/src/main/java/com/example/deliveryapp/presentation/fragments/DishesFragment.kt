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
import com.example.deliveryapp.domain.models.DomainChoiceDishesList
import com.example.deliveryapp.presentation.adapters.DishItemAdapter
import com.example.deliveryapp.presentation.viewmodels.DishesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        val dishes = viewModel.dishesList.value ?: DomainChoiceDishesList()

        binding.recyclerView.apply {
            adapter = DishItemAdapter(
                items = dishes,
                onItemClickEvent = { _, category ->
                    selectedDishesCategory(category)
                }
            )
        }
    }

    private fun selectedDishesCategory(selectedCategory: String) {
        navigationToDishesList(selectedCategory)
    }

    private fun navigationToDishesList(category: String) {
        val action = DishesFragmentDirections.actionDishesFragmentToFragmentDishesList(
            selectedCategory = category
        )
        findNavController().navigate(action)
    }
}