package app.localhost.mercadolivro.controllers.responses

import app.localhost.mercadolivro.enuns.BookStatus
import java.math.BigDecimal

data class BookResponse(
    var id: Long? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerResponse? = null,
    var status: BookStatus? = null
)
