package app.localhost.mercadolivro.services

import app.localhost.mercadolivro.enuns.CustomerStatus
import app.localhost.mercadolivro.models.CustomerModel
import app.localhost.mercadolivro.repositories.CustomerRespository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService(val customerRepository: CustomerRespository, val bookService: BookService) {
    val custormers = mutableListOf<CustomerModel>()

    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        name?.let { return this.customerRepository.findByNameContainingIgnoreCase(name) }
        return this.customerRepository.findAll().toList()
    }

    fun createCustomer(customer: CustomerModel) {
        this.customerRepository.save(customer)
    }

    fun getById(@PathVariable id: Long): CustomerModel {
        return this.customerRepository.findById(id).orElseThrow()
    }

    fun updateCustomer(customer: CustomerModel): CustomerModel {
        if (this.customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }
        this.customerRepository.save(customer)
        return customer
    }

    fun deleteCustomer(@PathVariable id: Long): CustomerModel {
        val customer = this.getById(id)
        this.bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.INACTIVE
        return this.customerRepository.save(customer)
    }
}
