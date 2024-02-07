package com.sample.webfluxreactivemongodb.core.usecase.impl

import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import com.sample.webfluxreactivemongodb.core.gateway.FindProductDsGateway
import com.sample.webfluxreactivemongodb.core.usecase.FindProductByIdUseCase
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FindProductByIdUseCaseImpl(
    private val findProductDsGateway: FindProductDsGateway
) : FindProductByIdUseCase {

    override fun execute(id: String): Mono<ProductOutputDto> {
        return findProductDsGateway
            .getById(id)
            .map { productOutputDsModel ->
                ProductOutputDto(
                    productOutputDsModel.id,
                    productOutputDsModel.description,
                    productOutputDsModel.price
                )
            }
    }
}