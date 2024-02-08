package com.sample.webfluxreactivemongodb.application.api.request

data class CreateProductRequest(
    val description: String,
    val price: Double
)