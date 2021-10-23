package app.localhost.mercadolivro.controllers.requests
import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PutBookRequest(
    var name: String,
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Long
)
