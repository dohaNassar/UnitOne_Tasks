package com.example.unitonetasks.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unitonetasks.databinding.CountryItemBinding
import com.example.unitonetasks.models.AllCity
import com.squareup.picasso.Picasso

class CountryAdapter(val data: List<AllCity>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val item: CountryItemBinding) : RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.item.apply {
            tvCountryName.text = data.get(position).name
            Picasso.get().load(data.get(position).imageURL).into(imgViewCountry)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}