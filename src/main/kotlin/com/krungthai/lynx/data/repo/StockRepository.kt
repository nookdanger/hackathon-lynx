package com.krungthai.lynx.data.repo
import com.krungthai.lynx.data.database.entities.Stock
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository

@Repository
data class StockRepository (
    private val r2dbcEntityTemplate: R2dbcEntityTemplate
){
    suspend fun findAll() = r2dbcEntityTemplate.select(Stock::class.java).all().onBackpressureBuffer().asFlow().toList()

}
