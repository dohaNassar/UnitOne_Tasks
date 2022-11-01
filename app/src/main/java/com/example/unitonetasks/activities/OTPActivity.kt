package com.example.unitonetasks.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitonetasks.databinding.ActivityMainBinding

class OTPActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}