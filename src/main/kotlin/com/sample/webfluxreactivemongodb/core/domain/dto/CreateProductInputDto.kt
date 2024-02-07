package com.sample.webfluxreactivemongodb.core.domain.dto

data class CreateProductInputDto(
    val description: String,
    val price: Double
)