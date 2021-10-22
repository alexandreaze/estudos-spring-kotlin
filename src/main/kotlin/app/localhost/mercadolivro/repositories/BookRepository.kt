package app.localhost.mercadolivro.repositories

import app.localhost.mercadolivro.models.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Long>
