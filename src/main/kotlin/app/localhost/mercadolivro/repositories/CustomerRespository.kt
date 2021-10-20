package app.localhost.mercadolivro.repositories

import app.localhost.mercadolivro.models.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRespository : CrudRepository<CustomerModel, Long> {
    fun findByNameContainingIgnoreCase(name: String): List<CustomerModel>
}
