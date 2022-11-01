package com.example.unitonetasks.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.unitonetasks.R
import com.example.unitonetasks.databinding.ActivityMainBinding
import com.example.unitonetasks.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        swipe(HomeFragment())
    }

    fun swipe(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment!!)
            .addToBackStack("").commit()
    }
}