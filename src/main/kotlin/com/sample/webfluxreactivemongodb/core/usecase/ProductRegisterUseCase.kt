package com.sample.webfluxreactivemongodb.core.usecase

import com.sample.webfluxreactivemongodb.core.dto.CreateProductInputDto
import com.sample.webfluxreactivemongodb.core.dto.ProductOutputDto
import reactor.core.publisher.Mono

interface ProductRegisterUseCase {

    fun execute(createProductInput: CreateProductInputDto): Mono<ProductOutputDto>
}