package com.blazers.githubapp.search.model

data class SearchResultModel(
    val total_count: Int,
    val items: List<ItemModel>
)

data class ItemModel(
    val id: Int,
    val name: String,
    val full_name: String,
    val description: String?,
    val stargazers_count: Int,
    val language: String?,
    val updated_at: String,
    val topics: List<String>?,
    val owner: OwnerModel
)

data class OwnerModel(
    val login: String,
    val avatar_url: String,
)