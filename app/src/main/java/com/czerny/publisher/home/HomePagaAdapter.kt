package com.czerny.publisher.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.czerny.publisher.databinding.ItemViewHomePageBinding

class HomePagaAdapter (): ListAdapter<MockData, HomeViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(
            ItemViewHomePageBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}



class HomeViewHolder( var binding:ItemViewHomePageBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MockData) {
        binding.itemViewModel = item
        binding.executePendingBindings()
    }
}

class DiffCallBack : DiffUtil.ItemCallback<MockData>() {
    override fun areItemsTheSame(oldItem: MockData, newItem: MockData): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: MockData, newItem: MockData): Boolean {
        return oldItem == newItem
    }
}