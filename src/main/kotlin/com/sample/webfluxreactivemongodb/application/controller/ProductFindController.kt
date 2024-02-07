package com.sample.webfluxreactivemongodb.application.controller

import com.sample.webfluxreactivemongodb.application.api.ProductFindApi
import com.sample.webfluxreactivemongodb.core.dto.ProductOutputDto
import com.sample.webfluxreactivemongodb.core.usecase.FindProductByIdUseCase
import com.sample.webfluxreactivemongodb.core.usecase.RetrieveAllProductsUseCase
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class ProductFindController(
    private val productByIdUseCase: FindProductByIdUseCase,
    private val allProductsUseCase: RetrieveAllProductsUseCase
) : ProductFindApi {

    override fun retrieveAll(): Flux<ProductOutputDto> {
        return allProductsUseCase
            .execute()
    }

    override fun retrieveById(
        id: String
    ): Mono<ProductOutputDto> {
        return productByIdUseCase
            .execute(id)
    }
}