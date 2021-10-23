package app.localhost.mercadolivro.extensions

import app.localhost.mercadolivro.controllers.requests.PostBookRequest
import app.localhost.mercadolivro.controllers.requests.PutBookRequest
import app.localhost.mercadolivro.controllers.responses.BookResponse
import app.localhost.mercadolivro.controllers.responses.CustomerResponse
import app.localhost.mercadolivro.enuns.BookStatus.ACTIVE
import app.localhost.mercadolivro.models.BookModel
import app.localhost.mercadolivro.models.CustomerModel

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(name = this.name, price = this.price, status = ACTIVE, customer = customer)
}

fun PutBookRequest.toBookModel(previewsValue: BookModel, customer: CustomerModel): BookModel {
    return BookModel(
        id = previewsValue.id,
        name = this.name ?: previewsValue.name,
        price = this.price ?: previewsValue.price,
        customer = customer
    )
}

fun BookModel.toBookResponse(customerResponse: CustomerResponse?): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = customerResponse,
        status = this.status
    )
}

