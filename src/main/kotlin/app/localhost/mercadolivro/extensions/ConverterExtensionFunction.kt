package app.localhost.mercadolivro.extensions

import app.localhost.mercadolivro.controllers.requests.PostCustomerRequest
import app.localhost.mercadolivro.controllers.requests.PutCustomerRequest
import app.localhost.mercadolivro.controllers.responses.CustomerResponse
import app.localhost.mercadolivro.enuns.CustomerStatus
import app.localhost.mercadolivro.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ACTIVE)
}

fun PutCustomerRequest.toCustomerModel(previewsValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previewsValue.id,
        name = this.name ?: previewsValue.name,
        email = this.email ?: previewsValue.email,
        status = previewsValue.status
    )
}

fun CustomerModel.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        status = this.status
    )
}
