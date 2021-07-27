package com.krungthai.lynx.api


import com.krungthai.lynx.data.repo.StockRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class Handler(
    private val stockRepository: StockRepository
) {
    suspend fun stock(serverRequest: ServerRequest) =
        serverRequest.awaitBody<Req>().let {
            ServerResponse.ok().json().bodyValueAndAwait(
                stockRepository.findAll()
            )
        }

    suspend fun hello(serverRequest: ServerRequest) =
        serverRequest.awaitBody<Req>().let {
            ServerResponse.ok().json().bodyValueAndAwait(
              "hello"
            )
        }
}