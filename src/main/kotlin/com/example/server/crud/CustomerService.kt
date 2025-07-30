package com.example.server.crud

import org.springframework.stereotype.Service

/**
 * Interface of service class with methods for manipulating Customer data
 * MEMO: This file might ignore DDD style.
 */
interface CustomerService {
    /**
     * Add a customer
     *
     * @param firstName
     * @param lastName
     */
    fun insertCustomer(firstName: String, lastName: String)

    /**
     * Select all customers
     */
    fun selectCustomers(): List<Customer>

    /**
     * Update a customer
     *
     * @param id
     * @param firstName
     * @param lastName
     */
    fun updateCustomer(id: Long, firstName: String, lastName: String)

    /**
     * Delete the customer
     *
     * @param id
     */
    fun deleteCustomer(id: Long)
}

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    override fun insertCustomer(firstName: String, lastName: String) {
        customerRepository.add(firstName, lastName)
        return
    }

    override fun selectCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    override fun updateCustomer(id: Long, firstName: String, lastName: String) {
        customerRepository.update(id, firstName, lastName)
        return
    }

    override fun deleteCustomer(id: Long) {
        customerRepository.delete(id)
        return
    }
}
