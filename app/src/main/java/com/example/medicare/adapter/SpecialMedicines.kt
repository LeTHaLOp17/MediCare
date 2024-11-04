package com.example.medicare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.medicare.databinding.SpecialMedicinesBinding

class SpecialMedicines(
    private val nameS: List<String>,
    private val companyS: List<String>,
    private val expiryDateS: List<String>,
    private val offPerS: List<String>,
    private val mrpS: List<String>,
    private val quantityS: List<String>,
    private val priceS: List<String>,
    private val imageS: List<Int>
) : RecyclerView.Adapter<SpecialMedicines.SpecialMedicinesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialMedicinesViewHolder {
        // Correctly instantiate the binding
        val binding = SpecialMedicinesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpecialMedicinesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpecialMedicinesViewHolder, position: Int) {
        holder.bind(
            name = nameS[position],
            image = imageS[position],
            company = companyS[position],
            expiryDate = expiryDateS[position],
            quantity = quantityS[position],
            mrp = mrpS[position],
            offPer = offPerS[position],
            price = priceS[position]
        )
    }

    override fun getItemCount(): Int {
        return nameS.size
    }

    class SpecialMedicinesViewHolder(private val binding: SpecialMedicinesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            name: String,
            image: Int,
            company: String,
            expiryDate: String,
            quantity: String,
            mrp: String,
            offPer: String,
            price: String
        ) {
            binding.productname.text = name
            binding.productimage.setImageResource(image)
            binding.company.text = company
            binding.expiry.text = expiryDate
            binding.productquantity.text = quantity
            binding.mrpbtn.text = "MRP Rs.$mrp"
            binding.off.text = "$offPer% off"
            binding.price.text = "Rs. $price"
        }
    }
}
