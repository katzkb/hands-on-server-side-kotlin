package com.example.server.crud

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

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

@Repository
class CustomerRepositoryImpl(val namedParameterJdbcProfiles: NamedParameterJdbcTemplate) : CustomerRepository {
    override fun add(firstName: String, lastName: String) {
        val sql = """
      INSERT INTO customer(first_name, last_name)
      VALUES (:first_name, :last_name)
      ;
        """.trimIndent()

        val sqlParams = MapSqlParameterSource()
            .addValue("first_name", firstName)
            .addValue("last_name", lastName)

        namedParameterJdbcProfiles.update(sql, sqlParams)
        return
    }

    override fun findAll(): List<Customer> {
        val sql = """
      SELECT id, first_name, last_name
      FROM customer
      ;
        """.trimIndent()

        val sqlParams = MapSqlParameterSource()
        val customerMap = namedParameterJdbcProfiles.queryForList(sql, sqlParams)
        return customerMap.map {
            Customer(
                it["id"].toString().toInt().toLong(),
                it["first_name"].toString(),
                it["last_name"].toString()
            )
        }
    }

    override fun update(id: Long, firstName: String, lastName: String) {
        val sql = """
      UPDATE customer
      SET
        first_name = :first_name
        , last_name = :last_name
      WHERE id = :id
      ;
        """.trimIndent()

        val sqlParams = MapSqlParameterSource()
            .addValue("first_name", firstName)
            .addValue("last_name", lastName)
            .addValue("id", id)

        namedParameterJdbcProfiles.update(sql, sqlParams)
        return
    }

    override fun delete(id: Long) {
        val sql = """
      DELETE FROM customer
      WHERE id = :id
      ;
        """.trimIndent()

        val sqlParams = MapSqlParameterSource()
            .addValue("id", id)

        namedParameterJdbcProfiles.update(sql, sqlParams)
        return
    }
}
