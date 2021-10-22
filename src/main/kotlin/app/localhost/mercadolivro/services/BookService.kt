package app.localhost.mercadolivro.services

import app.localhost.mercadolivro.controllers.requests.PostBookRequest
import app.localhost.mercadolivro.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {
    fun create(request: PostBookRequest) {
        this.bookRepository.save(request)
    }
}
