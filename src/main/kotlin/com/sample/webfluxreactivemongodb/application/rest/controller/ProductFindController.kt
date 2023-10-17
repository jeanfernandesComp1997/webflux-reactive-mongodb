package com.sample.webfluxreactivemongodb.application.rest.controller

import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import com.sample.webfluxreactivemongodb.core.usecase.FindProductUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("products")
class ProductFindController(
    private val findProductUseCase: FindProductUseCase
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): Flux<ProductOutputModel> {
        return findProductUseCase
            .getAll()
    }
}