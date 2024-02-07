package com.sample.webfluxreactivemongodb.core.gateway

import com.sample.webfluxreactivemongodb.core.domain.model.ProductInputDsModel
import com.sample.webfluxreactivemongodb.core.domain.model.ProductOutputDsModel
import reactor.core.publisher.Mono

interface ProductRegisterDsGateway {

    fun save(productInputDsModel: ProductInputDsModel): Mono<ProductOutputDsModel>
}