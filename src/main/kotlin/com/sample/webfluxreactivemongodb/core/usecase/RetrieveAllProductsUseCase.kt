package com.sample.webfluxreactivemongodb.core.usecase

import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import reactor.core.publisher.Flux

interface RetrieveAllProductsUseCase {

    fun execute(): Flux<ProductOutputDto>
}