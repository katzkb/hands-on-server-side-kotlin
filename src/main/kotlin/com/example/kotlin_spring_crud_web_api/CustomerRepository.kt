package com.example.kotlin_spring_crud_web_api

/**
 * Interface with methods for manipulating customer tables
 * MEMO: This file might ignore DDD style.
 */
interface CustomerRepository {
  /**
   * Method of insert data to the customer table
   *
   * @param firstName
   * @param lastName
   */
  fun add(firstName: String, lastName: String)

  /**
   * Method of find all data from the customer table
   *
   * @return List of all customers
   */
  fun findAll(): List<Customer>

  /**
   * Method of update data by id in the customer table
   *
   * @param id
   * @param firstName
   * @param lastName
   */
  fun update(id: Long, firstName: String, lastName: String)

  /**
   * Method of delete data by id from the customer table
   *
   * @param id
   */
  fun delete(id: Long)
}
