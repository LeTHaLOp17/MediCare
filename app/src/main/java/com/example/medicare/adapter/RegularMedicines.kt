package com.example.medicare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medicare.databinding.RegularMedicinesBinding

class RegularMedicines(
    private val name: List<String>,
    private val company: List<String>,
    private val expiryDate: List<String>,
    private val offPer: List<String>,
    private val mrp: List<String>,
    private val quantity: List<String>,
    private val price: List<String>,
    private val image: List<Int>
) : RecyclerView.Adapter<RegularMedicines.RegularMedicinesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegularMedicinesViewHolder {
        val binding = RegularMedicinesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RegularMedicinesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegularMedicinesViewHolder, position: Int) {
        holder.bind(
            name = name[position],
            image = image[position],
            company = company[position],
            expiryDate = expiryDate[position],
            quantity = quantity[position],
            mrp = mrp[position],
            offPer = offPer[position],
            price = price[position]
        )
    }

    override fun getItemCount(): Int {
        return name.size
    }

    class RegularMedicinesViewHolder(private val binding: RegularMedicinesBinding) : RecyclerView.ViewHolder(binding.root) {
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
