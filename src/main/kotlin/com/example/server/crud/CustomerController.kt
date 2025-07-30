package com.example.server.crud

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Define web api for do CURD of Customer table
 *
 * @param customerService
 */
@RestController
class CustomerController(val customerService: CustomerService) {

    /**
     * Endpoint for adding a customer
     *
     * @param request
     * @return
     */
    @PostMapping("/customers")
    fun insert(@RequestBody request: CustomerRequest): String {
        customerService.insertCustomer(request.firstName, request.lastName)
        return """
      {
        "message": "success"
      }
        """.trimIndent()
    }

    /**
     * Endpoint for selecting all customers
     *
     * @return
     */
    @GetMapping("/customers")
    fun read(): CustomerResponse {
        return CustomerResponse(customers = customerService.selectCustomers())
    }

    /**
     * Endpoint for updating a customer
     *
     * @param id
     * @param request
     * @return
     */
    @PutMapping("/customers/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: CustomerRequest): String {
        customerService.updateCustomer(id, request.firstName, request.lastName)
        return """
      {
        "message": "success"
      }
        """.trimIndent()
    }

    /**
     * Endpoint for deleting a customer
     *
     * @param id
     */
    @DeleteMapping("/customers/{id}")
    fun delete(@PathVariable("id") id: Long): String {
        customerService.deleteCustomer(id)
        return """
      {
        "message": "success"
      }
        """.trimIndent()
    }
}

/**
 * The request body for adding and updating customers
 *
 * @param firstName
 * @param lastName
 */
data class CustomerRequest(
    @JsonProperty("first_name") val firstName: String,
    @JsonProperty("last_name") val lastName: String,
)

/**
 * The response for the endpoint of select all customers
 *
 * @param customers
 */
data class CustomerResponse(
    val customers: List<Customer>,
)
