package app.localhost.mercadolivro.extensions

import app.localhost.mercadolivro.controllers.requests.PostCustomerRequest
import app.localhost.mercadolivro.controllers.requests.PutCustomerRequest
import app.localhost.mercadolivro.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Long): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
