package com.sample.webfluxreactivemongodb.core.dto

data class ProductOutputDto(
    val id: String,
    val description: String,
    val price: Double
)