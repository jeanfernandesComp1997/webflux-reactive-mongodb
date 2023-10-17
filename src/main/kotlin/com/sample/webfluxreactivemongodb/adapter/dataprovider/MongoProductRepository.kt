package com.sample.webfluxreactivemongodb.adapter.dataprovider

import com.sample.webfluxreactivemongodb.adapter.mapper.ProductDataMapper
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoProductRepository : ReactiveMongoRepository<ProductDataMapper, String> {
}