package com.example.deliveryapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryapp.R
import com.example.deliveryapp.data.local.DishItem
import com.example.deliveryapp.databinding.DishesItemBinding

class DishItemAdapter(
    private val items: List<DishItem>,
    private val onItemClickEvent: (View) -> Unit
) : RecyclerView.Adapter<DishItemAdapter.ViewHolder>() {

    private lateinit var binding: DishesItemBinding

    inner class ViewHolder(
        item: View,
        private val binding: DishesItemBinding
    ) : RecyclerView.ViewHolder(item) {

        fun bind(dish: DishItem) {
            binding.apply {
                dishItemImage.setImageResource(dish.imageId)
                dishItemTextLogo.setImageResource(dish.imageLogoId)
                dishItemText.text = dish.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dishes_item, parent, false)
        val binding = DishesItemBinding.bind(itemView)

        itemView.setOnClickListener {
            onItemClickEvent(it)
        }

        return ViewHolder(itemView, binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size
}