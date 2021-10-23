package app.localhost.mercadolivro.services

import app.localhost.mercadolivro.enuns.BookStatus
import app.localhost.mercadolivro.enuns.Errors
import app.localhost.mercadolivro.exceptions.NotFoundException
import app.localhost.mercadolivro.models.BookModel
import app.localhost.mercadolivro.models.CustomerModel
import app.localhost.mercadolivro.repositories.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {
    fun create(book: BookModel) {
        this.bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return this.bookRepository.findAll(pageable)
    }

    fun findActive(pageable: Pageable): Page<BookModel> {
        return this.bookRepository.findByStatus(BookStatus.ACTIVE, pageable)
    }

    fun findById(id: Long): BookModel? {
        return this.bookRepository.findById(id).orElseThrow { NotFoundException(message = Errors.ML0001.message.format(id), errorCode = Errors.ML0001.code) }
    }

    fun delete(id: Long) {
        val book = this.findById(id)
        if (book != null) {
            book.status = BookStatus.CANCELED
            this.update(book)
        }
    }

    fun update(book: BookModel) {
        this.bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = this.bookRepository.findByCustomer(customer)
        for (book in books) {
            book.status = BookStatus.DELETED
        }
        this.bookRepository.saveAll(books)
    }
}
