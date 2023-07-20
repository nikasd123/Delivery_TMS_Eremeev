package com.example.deliveryapp.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.DishesChoiceItemBinding
import com.example.deliveryapp.domain.models.DomainChoiceDishes
import com.example.deliveryapp.domain.models.DomainChoiceDishesList

class DishItemAdapter(
    private val items: DomainChoiceDishesList,
    private val onItemClickEvent: (View, String) -> Unit,
) : RecyclerView.Adapter<DishItemAdapter.ViewHolder>() {

    inner class ViewHolder(
        item: View,
        private val binding: DishesChoiceItemBinding
    ) : RecyclerView.ViewHolder(item) {
        fun bind(dish: DomainChoiceDishes) {
            binding.apply {
                dishItemImage.setImageResource(dish.imageId)
                dishItemTextLogo.setImageResource(dish.imageLogoId)
                dishItemText.text = dish.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dishes_choice_item, parent, false)
        val binding = DishesChoiceItemBinding.bind(itemView)

        return ViewHolder(itemView, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = items.dishes[position]

        holder.apply {
            bind(dish)
            itemView.setOnClickListener {
                onItemClickEvent(it, dish.category)
            }
        }
    }

    override fun getItemCount(): Int = items.dishes.size
}