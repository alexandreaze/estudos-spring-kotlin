package app.localhost.mercadolivro.controllers.requests
import app.localhost.mercadolivro.enuns.BookStatus
import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest(
    var name: String,
    var status: BookStatus = BookStatus.ACTIVE,
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Long
)
