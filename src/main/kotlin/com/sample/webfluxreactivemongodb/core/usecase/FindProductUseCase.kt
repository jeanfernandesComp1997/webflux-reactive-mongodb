package com.sample.webfluxreactivemongodb.core.usecase

import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FindProductUseCase {

    fun getAll(): Flux<ProductOutputModel>
    fun getById(id: String): Mono<ProductOutputModel>
}