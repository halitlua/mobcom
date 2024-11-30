package com.example.storedatalacedmnl.storedatalacedmnl.Model

data class Order(
    val orderId: String = "",
    val items: List<Item> = emptyList(),
    val totalPrice: Double = 0.0
)

data class Item(
    val itemId: String = "",
    val title: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0
)
