package com.sample.webfluxreactivemongodb.adapter.dataprovider

import com.sample.webfluxreactivemongodb.adapter.mapper.ProductDataMapper
import com.sample.webfluxreactivemongodb.core.model.ProductInputDsModel
import com.sample.webfluxreactivemongodb.core.model.ProductOutputDsModel
import com.sample.webfluxreactivemongodb.core.port.FindProductDsGateway
import com.sample.webfluxreactivemongodb.core.port.ProductRegisterDsGateway
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class MongoProduct(
    private val repository: MongoProductRepository
) : ProductRegisterDsGateway, FindProductDsGateway {

    override fun save(productInputDsModel: ProductInputDsModel): Mono<ProductOutputDsModel> {
        val productMapped = ProductDataMapper(
            productInputDsModel.id,
            productInputDsModel.description,
            productInputDsModel.price
        )
        return repository
            .save(productMapped)
            .map { product ->
                ProductOutputDsModel(
                    product.id,
                    product.description,
                    product.price
                )
            }
    }

    override fun getAll(): Flux<ProductOutputDsModel> {
        return repository
            .findAll()
            .map { product ->
                ProductOutputDsModel(
                    product.id,
                    product.description,
                    product.price
                )
            }
    }

    override fun getById(id: String): Mono<ProductOutputDsModel> {
        return repository
            .findById(id)
            .map { product ->
                ProductOutputDsModel(
                    product.id,
                    product.description,
                    product.price
                )
            }
    }
}