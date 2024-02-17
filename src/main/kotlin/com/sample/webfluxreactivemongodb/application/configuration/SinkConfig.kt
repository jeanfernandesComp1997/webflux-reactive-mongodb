package com.sample.webfluxreactivemongodb.application.configuration

import com.sample.webfluxreactivemongodb.core.domain.dto.ProductOutputDto
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks

@Configuration
class SinkConfig {

    @Bean
    fun sink(): Sinks.Many<ProductOutputDto> {
        return Sinks
            .many()
            .replay()
            .limit(1)
    }

    @Bean
    fun productBroadcast(sink: Sinks.Many<ProductOutputDto>): Flux<ProductOutputDto> {
        return sink.asFlux()
    }
}