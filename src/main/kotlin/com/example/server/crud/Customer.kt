package com.example.server.crud

/**
 * Data model used in web APIs
 *
 * @property id Customer ID
 * @property firstName
 * @property lastName
 */
data class Customer(
    val id: Long,
    val firstName: String,
    val lastName: String,
)
