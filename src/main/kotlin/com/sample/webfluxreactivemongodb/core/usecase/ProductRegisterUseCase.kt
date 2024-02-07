package com.sample.webfluxreactivemongodb.core.usecase

import com.sample.webfluxreactivemongodb.core.domain.dto.CreateProductInputDto
import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import reactor.core.publisher.Mono

interface ProductRegisterUseCase {

    fun execute(createProductInput: CreateProductInputDto): Mono<ProductOutputDto>
}