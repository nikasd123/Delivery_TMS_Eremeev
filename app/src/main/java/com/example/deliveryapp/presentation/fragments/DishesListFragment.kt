package com.example.deliveryapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentDishesListBinding
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.presentation.adapters.DishesListItemAdapter
import com.example.deliveryapp.presentation.viewmodels.DishesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DishesListFragment : Fragment(R.layout.fragment_dishes_list) {
    private lateinit var binding: FragmentDishesListBinding
    private val args: DishesListFragmentArgs by navArgs()
    private val viewModel: DishesListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDishesListBinding.bind(view)
        val selectedCategory = args.selectedCategory

        viewModel.getImagesByCategory(selectedCategory)
        Log.d("AAA", "choices category is: $selectedCategory")

        observeDishes()
    }

    private fun observeDishes() {
        viewModel.imagesList.observe(viewLifecycleOwner) {
            it?.let {
                initRecycler(it)
            }
        }
    }

    private fun initRecycler(dishes: List<DomainDishes>) {
        val selectedCategory = args.selectedCategory

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DishesListItemAdapter(
                dishesList = dishes,
                selectedCategory = selectedCategory
            )
        }
    }
}