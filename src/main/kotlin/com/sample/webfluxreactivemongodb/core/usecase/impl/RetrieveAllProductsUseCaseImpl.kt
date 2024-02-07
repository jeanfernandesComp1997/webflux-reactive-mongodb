package com.sample.webfluxreactivemongodb.core.usecase.impl

import com.sample.webfluxreactivemongodb.core.dto.ProductOutputDto
import com.sample.webfluxreactivemongodb.core.gateway.FindProductDsGateway
import com.sample.webfluxreactivemongodb.core.usecase.RetrieveAllProductsUseCase
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class RetrieveAllProductsUseCaseImpl(
    private val findProductDsGateway: FindProductDsGateway
) : RetrieveAllProductsUseCase {

    override fun execute(): Flux<ProductOutputDto> {
        return findProductDsGateway
            .getAll()
            .map { productOutputDsModel ->
                ProductOutputDto(
                    productOutputDsModel.id,
                    productOutputDsModel.description,
                    productOutputDsModel.price
                )
            }

    }
}