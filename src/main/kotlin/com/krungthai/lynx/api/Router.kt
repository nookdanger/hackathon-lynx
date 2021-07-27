package com.krungthai.lynx.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Router {
    @Bean
    fun routers(
        handler: Handler,
    ) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/stock".nest {
                POST("", handler::stock)
            }
            "/hello".nest {
                POST("", handler::hello)
            }
        }
    }
}