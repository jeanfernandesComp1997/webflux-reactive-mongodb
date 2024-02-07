package com.sample.webfluxreactivemongodb.application.api

import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RequestMapping("products")
interface ProductFindApi {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun retrieveAll(): Flux<ProductOutputDto>

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun retrieveById(@PathVariable("id") id: String): Mono<ProductOutputDto>
}