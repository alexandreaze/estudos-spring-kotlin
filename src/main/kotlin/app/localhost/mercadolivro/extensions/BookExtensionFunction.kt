package app.localhost.mercadolivro.extensions

import app.localhost.mercadolivro.controllers.requests.PostBookRequest
import app.localhost.mercadolivro.models.BookModel

fun PostBookRequest.toBookModel(): BookModel {
    return BookModel(name = this.name, price = this.price, status = this.status, customerId = this.customerId)
}

