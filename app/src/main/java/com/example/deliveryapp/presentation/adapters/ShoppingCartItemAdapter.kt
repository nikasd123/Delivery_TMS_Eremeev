package com.example.deliveryapp.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryapp.databinding.ShoppingCartItemBinding
import com.example.deliveryapp.domain.models.DomainDishes

class ShoppingCartItemAdapter(
    private val cartItems: List<DomainDishes>
) : RecyclerView.Adapter<ShoppingCartItemAdapter.ViewHolder>(){

    inner class ViewHolder(
        private val binding: ShoppingCartItemBinding
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingCartItemAdapter.ViewHolder {
        val binding = ShoppingCartItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingCartItemAdapter.ViewHolder, position: Int) {
        holder.bind(cartItems[position])
    }

    override fun getItemCount(): Int = cartItems.size
}