package com.sample.webfluxreactivemongodb.application.api

import com.sample.webfluxreactivemongodb.core.dto.CreateProductInputDto
import com.sample.webfluxreactivemongodb.core.dto.ProductOutputDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import reactor.core.publisher.Mono

@RequestMapping("products")
interface ProductRegisterApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody createProductInput: CreateProductInputDto): Mono<ProductOutputDto>
}