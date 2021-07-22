package com.example.covidres.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidres.databinding.RvItemBinding
import com.example.covidres.model.Resource

class MyAdapter(
    private val resources: List<Resource>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindViews(resource: Resource) {
            binding.apply {
                updatedItem.text = resource.updated.toString()
                casesItem.text = resource.cases.toString()
                todayCaseItem.text = resource.todayCases.toString()
                deathItem.text = resource.deaths.toString()
                todayDeathItem.text = resource.deaths.toString()
                recoveredItem.text = resource.recovered.toString()
                activeItem.text = resource.active.toString()
                criticalItem.text = resource.critical.toString()
                continentItem.text = resource.continent
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViews(resources[position])
    }

    override fun getItemCount(): Int {
        return resources.size
    }

}