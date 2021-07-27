package com.krungthai.lynx.data.database.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("stock")
data class Stock (
    @Id
    var merchantId: String,
    var productId: String,
    var productName: String?,
    var volume: Int?,
    var createdDate: LocalDateTime?,
    var updatedDate:LocalDateTime?,
    var createBy: String?,
    var updateBy: String?,
)