package app.localhost.mercadolivro.controllers

import app.localhost.mercadolivro.controllers.requests.PostBookRequest
import app.localhost.mercadolivro.services.BookService
import app.localhost.mercadolivro.services.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController(val bookService: BookService, val customerService: CustomerService) {
    @PostMapping
    fun create(@RequestBody request: PostBookRequest) {
        val customer = this.customerService.getById(request.customerId)
        this.bookService.create(request)
    }
}
