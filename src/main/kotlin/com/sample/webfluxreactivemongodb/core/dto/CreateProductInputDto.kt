package com.sample.webfluxreactivemongodb.core.dto

data class CreateProductInputDto(
    val description: String,
    val price: Double
)