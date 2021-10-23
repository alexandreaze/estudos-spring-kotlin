package app.localhost.mercadolivro.controllers.responses

import app.localhost.mercadolivro.enuns.CustomerStatus

data class CustomerResponse(
    var id: Long? = null,
    var name: String,
    var status: CustomerStatus
)
