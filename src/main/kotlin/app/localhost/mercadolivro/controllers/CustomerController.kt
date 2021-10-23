package app.localhost.mercadolivro.controllers

import app.localhost.mercadolivro.controllers.requests.PostCustomerRequest
import app.localhost.mercadolivro.controllers.requests.PutCustomerRequest
import app.localhost.mercadolivro.controllers.responses.CustomerResponse
import app.localhost.mercadolivro.extensions.toCustomerModel
import app.localhost.mercadolivro.extensions.toCustomerResponse
import app.localhost.mercadolivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerResponse> {
        return this.customerService.getAll(name).map { it.toCustomerResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        this.customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Long): CustomerResponse {
        return this.customerService.getById(id).toCustomerResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: PutCustomerRequest): CustomerResponse {
        val customerSaved = this.customerService.getById(id)
        return this.customerService.updateCustomer(customer.toCustomerModel(customerSaved)).toCustomerResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long): CustomerResponse {
        return this.customerService.deleteCustomer(id).toCustomerResponse()
    }
}
