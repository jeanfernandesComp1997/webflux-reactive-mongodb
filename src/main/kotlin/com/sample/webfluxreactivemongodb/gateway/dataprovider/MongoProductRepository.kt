package com.sample.webfluxreactivemongodb.gateway.dataprovider

import com.sample.webfluxreactivemongodb.gateway.dataprovider.mapper.ProductDataMapper
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoProductRepository : ReactiveMongoRepository<ProductDataMapper, String> {
}