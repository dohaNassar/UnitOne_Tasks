package com.example.unitonetasks.adaptersclass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.unitonetasks.R
import com.example.unitonetasks.databinding.CountryItemBinding
import com.example.unitonetasks.databinding.SliderItemBinding
import com.example.unitonetasks.models.AllCity
import com.example.unitonetasks.models.Slider
import com.squareup.picasso.Picasso
import java.util.*

class SliderAdapter( val data: List<Slider>) : PagerAdapter() {
    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = SliderItemBinding.inflate(LayoutInflater.from(container.context), container, false)
        Picasso.get().load(data[position%data.size].imageURL).into(binding.imgViewCountry)
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}