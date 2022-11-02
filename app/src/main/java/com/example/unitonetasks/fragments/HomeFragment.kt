package com.example.unitonetasks.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import com.example.unitonetasks.activities.LoginActivity
import com.example.unitonetasks.adapters.CountryAdapter
import com.example.unitonetasks.adaptersclass.SliderAdapter
import com.example.unitonetasks.databinding.ActivityMainBinding
import com.example.unitonetasks.databinding.FragmentHomeBinding
import com.example.unitonetasks.interfaces.QuotesApi
import com.example.unitonetasks.models.AllCity
import com.example.unitonetasks.models.RetrofitHelper
import com.example.unitonetasks.models.Slider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    lateinit var activityBinding: ActivityMainBinding
    lateinit var allCities: List<AllCity>
    lateinit var sliders: List<Slider>
    lateinit var viewPager: ViewPager
    lateinit var rv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)

        viewPager = binding.viewPager
        rv = binding.rv

        fetchData()
        binding.middleContent.btnSignup.setOnClickListener {
            gotToSignUp()
        }


        return binding.root
    }
    private fun gotToSignUp(){
        val intent = Intent(requireActivity(),LoginActivity::class.java)
        requireActivity().startActivity(intent)
    }


    private fun fetchData() {
        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        // launching a new coroutine
        CoroutineScope(Dispatchers.Main).launch {
            val result = quotesApi.getQuotes()
            //recycler
            allCities = result.body()!!.data.allCities
            Log.d("doha: ", result.body().toString())

            rv.adapter = CountryAdapter(allCities)

            sliders = result.body()!!.data.slider

            viewPager.adapter = SliderAdapter(sliders)


        }
    }

    private fun cycledViewPager() {

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        }
        )
    }


}