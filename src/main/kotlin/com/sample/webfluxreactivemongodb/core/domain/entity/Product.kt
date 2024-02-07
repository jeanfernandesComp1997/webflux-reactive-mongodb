package com.sample.webfluxreactivemongodb.core.domain.entity

import java.util.UUID

class Product {

    var id: String
        private set

    var description: String
        private set

    var price: Double
        private set

    constructor(
        id: String,
        description: String,
        price: Double
    ) {
        this.id = id
        this.description = description
        this.price = price
    }

    constructor(
        description: String,
        price: Double
    ) {
        this.id = UUID.randomUUID().toString()
        this.description = description
        this.price = price
    }
}