package com.sample.webfluxreactivemongodb.core.usecase.impl

import com.sample.webfluxreactivemongodb.core.command.CreateProductCommand
import com.sample.webfluxreactivemongodb.core.entity.Product
import com.sample.webfluxreactivemongodb.core.model.ProductInputDsModel
import com.sample.webfluxreactivemongodb.core.model.ProductOutputModel
import com.sample.webfluxreactivemongodb.core.port.ProductPresenter
import com.sample.webfluxreactivemongodb.core.port.ProductRegisterDsGateway
import com.sample.webfluxreactivemongodb.core.usecase.RegisterProductUseCase
import reactor.core.publisher.Mono

class RegisterProductUseCaseImpl(
    private val productRegisterDsGateway: ProductRegisterDsGateway,
    private val productPresenter: ProductPresenter
) : RegisterProductUseCase {

    override fun create(command: CreateProductCommand): Mono<ProductOutputModel> {
        val product = Product(
            command.description,
            command.price
        )
        val productInputDsModel = ProductInputDsModel(
            product.id,
            product.description,
            product.price
        )
        return productRegisterDsGateway
            .save(productInputDsModel)
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