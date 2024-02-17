package com.sample.webfluxreactivemongodb.application.api

import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Flux

@RequestMapping("products")
interface ProductStreamApi {

    @GetMapping(value = ["stream/{maxPrice}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun retrieveProductsUpdates(@PathVariable("maxPrice") maxPrice: Double): Flux<ProductOutputDto>
}