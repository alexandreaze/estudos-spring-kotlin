package app.localhost.mercadolivro.controllers

import app.localhost.mercadolivro.controllers.requests.PostCustomerRequest
import app.localhost.mercadolivro.controllers.requests.PutCustomerRequest
import app.localhost.mercadolivro.extensions.toCustomerModel
import app.localhost.mercadolivro.models.CustomerModel
import app.localhost.mercadolivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return this.customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        this.customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Long): CustomerModel {
        return this.customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: PutCustomerRequest): CustomerModel {
        return this.customerService.updateCustomer(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long) {
        return this.customerService.deleteCustomer(id)
    }
}
