package com.example.storedatalacedmnl.storedatalacedmnl.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.storedatalacedmnl.Model.ItemsModel
import com.example.storedatalacedmnl.databinding.ItemOrderBinding // Ensure correct import for the binding class

class OrderAdapter(private val orderItems: List<ItemsModel>) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    // ViewHolder class for binding views
    class ViewHolder(val binding: ItemOrderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orderItems[position]

        // Bind the data to the views
        holder.binding.apply {
            titleTxt.text = item.title
            feeEachItem.text = "₱${item.price}"
            numberItemTxt.text = item.numberInCart.toString()
            totalEachItem.text = "₱${item.numberInCart * item.price}"

            // Load the first image from picUrl using Glide
            Glide.with(holder.itemView.context)
                .load(item.picUrl.getOrNull(0)) // Handle potential empty list safely
                .apply(RequestOptions().transform(CenterCrop()))
                .into(pic) // Ensure `pic` ImageView is correctly referenced in `ItemOrderBinding`
        }
    }

    override fun getItemCount(): Int = orderItems.size
}
