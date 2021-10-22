package app.localhost.mercadolivro.services

import app.localhost.mercadolivro.models.CustomerModel
import app.localhost.mercadolivro.repositories.CustomerRespository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService(val customerRepository: CustomerRespository) {
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

    fun deleteCustomer(@PathVariable id: Long) {
        return this.customerRepository.deleteById(id)
    }
}
