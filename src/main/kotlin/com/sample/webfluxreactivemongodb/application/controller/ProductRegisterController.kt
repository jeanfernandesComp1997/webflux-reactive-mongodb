package com.sample.webfluxreactivemongodb.application.controller

import com.sample.webfluxreactivemongodb.application.api.ProductRegisterApi
import com.sample.webfluxreactivemongodb.core.domain.dto.CreateProductInputDto
import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import com.sample.webfluxreactivemongodb.core.usecase.ProductRegisterUseCase
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ProductRegisterController(
    private val registerProductUseCase: ProductRegisterUseCase
) : ProductRegisterApi {

    override fun register(@RequestBody createProductInput: CreateProductInputDto): Mono<ProductOutputDto> {
        return registerProductUseCase
            .execute(createProductInput)
    }
}