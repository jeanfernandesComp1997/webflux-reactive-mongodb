package com.sample.webfluxreactivemongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxReactiveMongodbApplication

fun main(args: Array<String>) {
	runApplication<WebfluxReactiveMongodbApplication>(*args)
}
