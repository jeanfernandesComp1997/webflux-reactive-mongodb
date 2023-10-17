package com.sample.webfluxreactivemongodb.core.usecase

import com.sample.webfluxreactivemongodb.core.command.CreateProductCommand
import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import reactor.core.publisher.Mono

interface RegisterProductUseCase {

    fun create(command: CreateProductCommand): Mono<ProductOutputModel>
}