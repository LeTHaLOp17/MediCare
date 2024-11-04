package com.example.medicare.adapter

data class MedicineItem(
    val name: String,
    val company: String,
    val expiryDate: String,
    val offPer: String,
    val mrp: String,
    val quantity: String,
    val price: String,
    val image: Int,
    val type: MedicineType  // Distinguishes Regular and Special types
)

enum class MedicineType {
    REGULAR, SPECIAL
}
