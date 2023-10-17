package com.sample.webfluxreactivemongodb.core.usecase.impl

import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import com.sample.webfluxreactivemongodb.core.port.FindProductDsGateway
import com.sample.webfluxreactivemongodb.core.port.ProductPresenter
import com.sample.webfluxreactivemongodb.core.usecase.FindProductUseCase
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class FindProductUseCaseImpl(
    private val findProductDsGateway: FindProductDsGateway,
    private val productPresenter: ProductPresenter
) : FindProductUseCase {

    override fun getAll(): Flux<ProductOutputModel> {
        return productPresenter
            .prepareSuccessView(
                findProductDsGateway
                    .getAll()
                    .map { productOutputDsModel ->
                        ProductOutputModel(
                            productOutputDsModel.id,
                            productOutputDsModel.description,
                            productOutputDsModel.price
                        )
                    }
            )
    }

    override fun getById(id: String): Mono<ProductOutputModel> {
        return findProductDsGateway
            .getById(id)
            .map { productOutputDsModel ->
                ProductOutputModel(
                    productOutputDsModel.id,
                    productOutputDsModel.description,
                    productOutputDsModel.price
                )
            }
            .flatMap { productOutputModel ->
                productPresenter.prepareSuccessView(productOutputModel)
            }
    }
}