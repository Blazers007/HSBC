package com.blazers.githubapp.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.blazers.githubapp.search.databinding.ItemResultBinding
import com.blazers.githubapp.search.model.ItemModel

class ResultAdapter(
    private val onItemClick: (String) -> Unit
) : PagingDataAdapter<ItemModel, ResultItemViewHolder>(ResultItemDiffCallback()) {

    override fun onBindViewHolder(holder: ResultItemViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemViewHolder {
        return ResultItemViewHolder(
            ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}

class ResultItemDiffCallback : DiffUtil.ItemCallback<ItemModel>() {
    override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem.id == newItem.id
    }
}

class ResultItemViewHolder(private val binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: ItemModel?) {
        data ?: return
        binding.tvItemTitle.text = data.full_name
        binding.tvItemDesc.text = data.description
        binding.tvLikeCount.text = data.stargazers_count.toString()
        binding.tvLanguage.text = data.language
        binding.tvUpdateTime.text = data.updated_at
    }
}