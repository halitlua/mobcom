package com.example.storedatalacedmnl.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storedatalacedmnl.Helper.ChangeNumberItemsListener
import com.example.storedatalacedmnl.Helper.ManagmentCart
import com.example.storedatalacedmnl.Adapter.CartAdapter
import com.example.storedatalacedmnl.Model.ItemsModel
import com.example.storedatalacedmnl.databinding.ActivityCartBinding

class CartActivity : BaseActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var managmentCart: ManagmentCart
    private var tax: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        setVariable()
        initCartList()
        calculateCart()
    }

    private fun initCartList() {
        binding.viewCart.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.viewCart.adapter =
            CartAdapter(managmentCart.getListCart(), this, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    calculateCart()
                }
            })

        with(binding) {
            emptyTxt.visibility =
                if (managmentCart.getListCart().isEmpty()) View.VISIBLE else View.GONE
            scrollView2.visibility =
                if (managmentCart.getListCart().isEmpty()) View.GONE else View.VISIBLE
        }
    }

    private fun calculateCart() {
        val percentTax = 0.02
        val delivery = 0
        tax = Math.round((managmentCart.getTotalFee() * percentTax) * 100) / 100.0
        val total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100
        val itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100

        with(binding) {
            totalFeeTxt.text = "₱$itemTotal"
            taxTxt.text = "₱$tax"
            deliveryTxt.text = "₱$delivery"
            totalTxt.text = "₱$total"
        }
    }

    private fun setVariable() {
        // Back button to finish the activity
        binding.backBtn.setOnClickListener { finish() }

        // Checkout button to navigate to MyOrderActivity
        binding.checkoutButton.setOnClickListener {
            // Collect the cart items to be passed to MyOrderActivity
            val cartItems = ArrayList<ItemsModel>(managmentCart.getListCart())

            // Create an Intent to navigate to MyOrderActivity
            val intent = Intent(this, MyOrderActivity::class.java).apply {
                putParcelableArrayListExtra("cartItems", cartItems)
            }
            startActivity(intent)
        }

    }
}
