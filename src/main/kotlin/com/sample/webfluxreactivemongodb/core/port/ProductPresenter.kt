package com.sample.webfluxreactivemongodb.core.port

import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ProductPresenter {

    fun prepareSuccessView(output: ProductOutputModel): Mono<ProductOutputModel>
    fun prepareSuccessView(output: Flux<ProductOutputModel>): Flux<ProductOutputModel>
    fun prepareFailView(error: Exception): Mono<ProductOutputModel>
}