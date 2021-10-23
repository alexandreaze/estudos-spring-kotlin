package app.localhost.mercadolivro.controllers

import app.localhost.mercadolivro.controllers.requests.PostBookRequest
import app.localhost.mercadolivro.controllers.requests.PutBookRequest
import app.localhost.mercadolivro.controllers.responses.BookResponse
import app.localhost.mercadolivro.extensions.toBookModel
import app.localhost.mercadolivro.extensions.toBookResponse
import app.localhost.mercadolivro.extensions.toCustomerResponse
import app.localhost.mercadolivro.models.BookModel
import app.localhost.mercadolivro.services.BookService
import app.localhost.mercadolivro.services.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController(val bookService: BookService, val customerService: CustomerService) {
    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = this.customerService.getById(request.customerId)
        this.bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return this.bookService.findAll(pageable).map { it.toBookResponse(it.customer?.toCustomerResponse()) }
    }

    @GetMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    fun findActive(pageable: Pageable): Page<BookModel> {
        return this.bookService.findActive(pageable)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: Long): BookModel? {
        return this.bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return this.bookService.delete(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody book: PutBookRequest) {
        val bookSave = this.bookService.findById(id)
        val customerSave = this.customerService.getById(book.customerId)
        if (bookSave != null) {
            this.bookService.update(book.toBookModel(bookSave, customerSave))
        }
    }
}


