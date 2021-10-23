package app.localhost.mercadolivro.repositories

import app.localhost.mercadolivro.enuns.BookStatus
import app.localhost.mercadolivro.models.BookModel
import app.localhost.mercadolivro.models.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel, Long> {
    fun findByStatus(bookStatus: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
//    fun findAll(pageable: Pageable): Page<BookModel>
}
