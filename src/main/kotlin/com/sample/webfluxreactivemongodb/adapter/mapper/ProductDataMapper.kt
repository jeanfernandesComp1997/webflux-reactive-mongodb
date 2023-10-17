package com.sample.webfluxreactivemongodb.adapter.mapper

import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
data class ProductDataMapper(
    val id: String,
    val description: String,
    val price: Double
)