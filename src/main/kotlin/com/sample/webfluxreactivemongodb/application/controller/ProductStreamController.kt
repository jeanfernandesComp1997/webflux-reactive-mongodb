package com.sample.webfluxreactivemongodb.application.controller

import com.sample.webfluxreactivemongodb.application.api.ProductStreamApi
import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ProductStreamController(
    private val flux: Flux<ProductOutputDto>
) : ProductStreamApi {

    override fun retrieveProductsUpdates(maxPrice: Double): Flux<ProductOutputDto> {
        return flux
            .filter { product ->
                product.price <= maxPrice
            }
    }
}