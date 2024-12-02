package com.example.storedatalacedmnl.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.storedatalacedmnl.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize your views and logic here
    }
}