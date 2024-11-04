package com.example.medicare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.medicare.Fragments.CartFragment
import com.example.medicare.databinding.CartItemBinding

class CartAdapter(private val cartItems:MutableList<String>, private val cartItemPrice:MutableList<String>, private val CartImage:MutableList<Int>)  : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartNameTxt.text = cartItems[position]
                cartPriceTxt.text = cartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemCount.text = quantity.toString()

                minusBtn.setOnClickListener{
                    decreaseQuantity(position)
                }
                addBtn.setOnClickListener{
                    increaseQuantity(position)
                }
                deleteImg.setOnClickListener{
                    val itemPosotion = adapterPosition
                    if(itemPosotion != RecyclerView.NO_POSITION){
                        deleteItem(itemPosotion)
                    }
                }

            }
        }
        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.cartItemCount.text = itemQuantities[position].toString()
            }
        }
        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.cartItemCount.text = itemQuantities[position].toString()
            }
        }
        private fun deleteItem(position: Int) {
            cartItems.removeAt(position)
            cartItemPrice.removeAt(position)
            CartImage.removeAt(position)
            itemQuantities[position] = 1
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
        }
    }
}