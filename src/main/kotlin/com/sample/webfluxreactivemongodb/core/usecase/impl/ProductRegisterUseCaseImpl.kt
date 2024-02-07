package com.sample.webfluxreactivemongodb.core.usecase.impl

import com.sample.webfluxreactivemongodb.core.domain.dto.CreateProductInputDto
import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import com.sample.webfluxreactivemongodb.core.domain.entity.Product
import com.sample.webfluxreactivemongodb.core.gateway.ProductRegisterDsGateway
import com.sample.webfluxreactivemongodb.core.domain.model.ProductInputDsModel
import com.sample.webfluxreactivemongodb.core.usecase.ProductRegisterUseCase
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ProductRegisterUseCaseImpl(
    private val productRegisterDsGateway: ProductRegisterDsGateway
) : ProductRegisterUseCase {

    override fun execute(createProductInput: CreateProductInputDto): Mono<ProductOutputDto> {
        val product = Product(
            createProductInput.description,
            createProductInput.price
        )
        val productInputDsModel = ProductInputDsModel(
            product.id,
            product.description,
            product.price
        )
        return productRegisterDsGateway
            .save(productInputDsModel)
            .map { productOutputDsModel ->
                ProductOutputDto(
                    productOutputDsModel.id,
                    productOutputDsModel.description,
                    productOutputDsModel.price
                )
            }
    }
}