package com.example.unitonetasks.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.widget.ViewPager2
import com.example.unitonetasks.adapters.CountryAdapter
import com.example.unitonetasks.adaptersclass.SliderAdapter
import com.example.unitonetasks.databinding.FragmentHomeBinding
import com.example.unitonetasks.interfaces.QuotesApi
import com.example.unitonetasks.models.AllCity
import com.example.unitonetasks.models.RetrofitHelper
import com.example.unitonetasks.models.Slider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding

    lateinit var allCities: List<AllCity>
    lateinit var sliders: List<Slider>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        fetchData()

        return binding.root
    }



    private fun fetchData(){
        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        // launching a new coroutine
        CoroutineScope(Dispatchers.Main).launch {
            val result = quotesApi.getQuotes()
            //recycler
            allCities = result.body()!!.data.allCities
            Log.d("doha: ", result.body().toString())

            binding.rv.adapter = CountryAdapter(allCities)

            sliders = result.body()!!.data.slider

            binding.viewPager.adapter = SliderAdapter( sliders)



        }
    }


}