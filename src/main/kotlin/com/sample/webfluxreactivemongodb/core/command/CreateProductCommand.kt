package com.sample.webfluxreactivemongodb.core.command

data class CreateProductCommand(
    val description: String,
    val price: Double
)