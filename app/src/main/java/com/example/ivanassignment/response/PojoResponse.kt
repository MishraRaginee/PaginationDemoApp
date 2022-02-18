package com.example.ivanassignment.response

data class PojoResponse(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)