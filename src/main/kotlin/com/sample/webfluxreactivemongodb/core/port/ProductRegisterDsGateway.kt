package com.sample.webfluxreactivemongodb.core.port

import com.sample.webfluxreactivemongodb.core.model.ProductInputDsModel
import com.sample.webfluxreactivemongodb.core.model.ProductOutputDsModel
import reactor.core.publisher.Mono

interface ProductRegisterDsGateway {

    fun save(productInputDsModel: ProductInputDsModel): Mono<ProductOutputDsModel>
}