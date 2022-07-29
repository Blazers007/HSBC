package com.blazers.githubapp.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blazers.githubapp.search.database.entity.QueryRecord
import com.blazers.githubapp.search.databinding.ItemQueryBinding

class QueryRecordAdapter(private val onItemClick: (String) -> Unit) :
    ListAdapter<QueryRecord, QueryRecordViewHolder>(QueryRecordDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueryRecordViewHolder {
        return QueryRecordViewHolder(ItemQueryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: QueryRecordViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClick(item.query) }
    }
}

class QueryRecordViewHolder(private val itemQueryBinding: ItemQueryBinding) :
    RecyclerView.ViewHolder(itemQueryBinding.root) {

    fun bind(queryRecord: QueryRecord) {
        itemQueryBinding.tvQuery.text = queryRecord.query
    }

}

class QueryRecordDiffCallback : DiffUtil.ItemCallback<QueryRecord>() {
    override fun areItemsTheSame(oldItem: QueryRecord, newItem: QueryRecord): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: QueryRecord, newItem: QueryRecord): Boolean {
        return oldItem.query == newItem.query
    }
}