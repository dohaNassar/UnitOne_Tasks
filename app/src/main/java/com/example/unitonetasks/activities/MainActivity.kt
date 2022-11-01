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
        changeTitle("Home")

        binding.fab.setOnClickListener {
            swipe(HomeFragment())
            changeTitle("Home")
        }

    }

    private fun changeTitle(title: String) {
        binding.myToolbar.toolbarTitle.text = title

    }

    fun swipe(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().replace(binding.container.id, fragment!!)
            .addToBackStack("").commit()
    }


    override fun onResume() {
        super.onResume()
        val nav = binding.bottomNavigationView
        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.hotels -> {
                    changeTitle("Hotels")
                }
                R.id.flights -> {
                    changeTitle("Flights")
                }
                R.id.search -> {
                    changeTitle("Search")
                }
                R.id.settings -> {
                    changeTitle("Settings")
                }

            }
            true
        }
    }

}