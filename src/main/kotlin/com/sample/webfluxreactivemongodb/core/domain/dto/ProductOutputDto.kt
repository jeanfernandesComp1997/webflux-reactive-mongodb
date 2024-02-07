package com.sample.webfluxreactivemongodb.core.domain.dto

data class ProductOutputDto(
    val id: String,
    val description: String,
    val price: Double
)