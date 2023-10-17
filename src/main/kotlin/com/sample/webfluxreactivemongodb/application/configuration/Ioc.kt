package com.sample.webfluxreactivemongodb.application.configuration

import com.sample.webfluxreactivemongodb.core.port.FindProductDsGateway
import com.sample.webfluxreactivemongodb.core.port.ProductPresenter
import com.sample.webfluxreactivemongodb.core.port.ProductRegisterDsGateway
import com.sample.webfluxreactivemongodb.core.usecase.FindProductUseCase
import com.sample.webfluxreactivemongodb.core.usecase.RegisterProductUseCase
import com.sample.webfluxreactivemongodb.core.usecase.impl.FindProductUseCaseImpl
import com.sample.webfluxreactivemongodb.core.usecase.impl.RegisterProductUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Ioc(
    private val productRegisterDsGateway: ProductRegisterDsGateway,
    private val productPresenter: ProductPresenter,
    private val findProductDsGateway: FindProductDsGateway
) {

    @Bean
    fun productRegisterUseCase(): RegisterProductUseCase {
        return RegisterProductUseCaseImpl(
            productRegisterDsGateway,
            productPresenter
        )
    }

    @Bean
    fun findProductUseCase(): FindProductUseCase {
        return FindProductUseCaseImpl(
            findProductDsGateway,
            productPresenter
        )
    }
}