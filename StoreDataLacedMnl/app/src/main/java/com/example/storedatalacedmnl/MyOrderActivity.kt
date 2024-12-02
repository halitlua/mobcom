package com.example.storedatalacedmnl.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.storedatalacedmnl.Model.ItemsModel
import com.example.storedatalacedmnl.databinding.ActivityMyOrderBinding
import com.example.storedatalacedmnl.storedatalacedmnl.Adapter.OrderAdapter

class MyOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the cart items passed from CartActivity
        val cartItems: ArrayList<ItemsModel>? = intent.getParcelableArrayListExtra("cartItems")

        // Initialize the RecyclerView with the OrderAdapter
        val orderAdapter = OrderAdapter(cartItems ?: arrayListOf()) // Use a default empty list if null
        binding.ordersRecyclerView.layoutManager = LinearLayoutManager(this) // RecyclerView ID matches activity_my_order.xml
        binding.ordersRecyclerView.adapter = orderAdapter

        // Set up the confirm order button click listener (if needed)
        binding.confirmOrderButton.setOnClickListener {
            // Add logic to confirm the order, such as navigating to another activity or displaying a confirmation dialog
        }
    }
}
