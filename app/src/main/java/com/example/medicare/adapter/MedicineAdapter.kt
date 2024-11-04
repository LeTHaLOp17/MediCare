package com.example.medicare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medicare.databinding.RegularMedicinesBinding
import com.example.medicare.databinding.SpecialMedicinesBinding

class MedicineAdapter(
    private val items: List<MedicineItem>,
    private val onItemClick: (MedicineItem) -> Unit // Click listener as a lambda)
 ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_REGULAR = 1
        private const val VIEW_TYPE_SPECIAL = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            MedicineType.REGULAR -> VIEW_TYPE_REGULAR
            MedicineType.SPECIAL -> VIEW_TYPE_SPECIAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_REGULAR -> {
                val binding = RegularMedicinesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RegularMedicineViewHolder(binding)
            }
            VIEW_TYPE_SPECIAL -> {
                val binding = SpecialMedicinesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SpecialMedicineViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is RegularMedicineViewHolder -> holder.bind(item)
            is SpecialMedicineViewHolder -> holder.bind(item, onItemClick)
        }
    }

    override fun getItemCount(): Int = items.size

    // ViewHolder for Regular Medicines
    class RegularMedicineViewHolder(private val binding: RegularMedicinesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MedicineItem) {
            binding.productname.text = item.name
            binding.productimage.setImageResource(item.image)
            binding.company.text = item.company
            binding.expiry.text = item.expiryDate
            binding.productquantity.text = item.quantity
            binding.mrpbtn.text = "MRP Rs.${item.mrp}"
            binding.off.text = "${item.offPer}% off"
            binding.price.text = "Rs. ${item.price}"
        }
    }

    // ViewHolder for Special Medicines
    class SpecialMedicineViewHolder(private val binding: SpecialMedicinesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MedicineItem, onItemClick: (MedicineItem) -> Unit) {
            binding.productname.text = item.name
            binding.productimage.setImageResource(item.image)
            binding.company.text = item.company
            binding.expiry.text = item.expiryDate
            binding.productquantity.text = item.quantity
            binding.mrpbtn.text = "MRP Rs.${item.mrp}"
            binding.off.text = "${item.offPer}% off"
            binding.price.text = "Rs. ${item.price}"
            binding.root.setOnClickListener { onItemClick(item) } // Set the click listener
        }
    }
}
