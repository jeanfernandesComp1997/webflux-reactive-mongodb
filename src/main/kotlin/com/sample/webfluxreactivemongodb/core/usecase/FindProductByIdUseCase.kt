package com.sample.webfluxreactivemongodb.core.usecase

import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import reactor.core.publisher.Mono

interface FindProductByIdUseCase {

    fun execute(id: String): Mono<ProductOutputDto>
}