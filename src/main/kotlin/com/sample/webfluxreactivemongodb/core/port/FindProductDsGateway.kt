package com.sample.webfluxreactivemongodb.core.port

import com.sample.webfluxreactivemongodb.core.model.ProductOutputDsModel
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FindProductDsGateway {

    fun getAll(): Flux<ProductOutputDsModel>
    fun getById(id: String): Mono<ProductOutputDsModel>
}