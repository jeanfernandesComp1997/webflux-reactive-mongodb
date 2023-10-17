package com.sample.webfluxreactivemongodb.adapter.formatter

import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import com.sample.webfluxreactivemongodb.core.port.ProductPresenter
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class ProductResponseFormatter : ProductPresenter {

    override fun prepareSuccessView(output: ProductOutputModel): Mono<ProductOutputModel> {
        return Mono.just(output)
    }

    override fun prepareSuccessView(output: Flux<ProductOutputModel>): Flux<ProductOutputModel> {
        return output
    }

    override fun prepareFailView(error: Exception): Mono<ProductOutputModel> {
        return Mono.error(error)
    }
}