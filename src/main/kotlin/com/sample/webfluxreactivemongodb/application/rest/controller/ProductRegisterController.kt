package com.sample.webfluxreactivemongodb.application.rest.controller

import com.sample.webfluxreactivemongodb.core.command.CreateProductCommand
import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import com.sample.webfluxreactivemongodb.core.usecase.RegisterProductUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("products")
class ProductRegisterController(
    private val registerProductUseCase: RegisterProductUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody command: CreateProductCommand): Mono<ProductOutputModel> {
        return registerProductUseCase
            .create(command)
    }
}