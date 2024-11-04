package com.example.medicare.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicare.R
import com.example.medicare.adapter.CartAdapter
import com.example.medicare.databinding.FragmentCartBinding
import com.example.medicare.databinding.SpecialMedicinesBinding

class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartMedicineName = listOf("Medicine 1", "Medicine 2", "Medicine 3")
        val cartMedicinePrice = listOf("Rs. 10", "Rs. 15", "Rs. 20")
        val cartMedicineImage = listOf(R.drawable.saridonimg, R.drawable.saridonimg, R.drawable.saridonimg)
        val adapter = CartAdapter(ArrayList(cartMedicineName), ArrayList(cartMedicinePrice), ArrayList(cartMedicineImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        return binding.root
    }
}