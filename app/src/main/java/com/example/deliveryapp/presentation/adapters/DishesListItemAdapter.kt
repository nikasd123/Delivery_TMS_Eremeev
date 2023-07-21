package com.example.deliveryapp.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryapp.databinding.DishesListItemBinding
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.presentation.OnDishItemClickListener

class DishesListItemAdapter(
    private var selectedCategory: String,
    private val dishesList: List<DomainDishes>,
    private val onDishItemClickListener: OnDishItemClickListener
) : RecyclerView.Adapter<DishesListItemAdapter.ViewHolder>() {
    inner class ViewHolder(
        private val binding: DishesListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(dish: DomainDishes) {
            binding.apply {
                dishesListItemName.text = dish.name
                dishesListItemCost.text = "cost: 5$"

                Glide.with(dishesListItemImage)
                    .load(dish.url)
                    .into(dishesListItemImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DishesListItemBinding.inflate(
            LayoutInflater.from
                (parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishesList[position]
        holder.apply {
            bind(dish)
            itemView.setOnClickListener {
                onDishItemClickListener.onDishClicked(dish)
            }
        }
    }

    override fun getItemCount(): Int = dishesList.size
}