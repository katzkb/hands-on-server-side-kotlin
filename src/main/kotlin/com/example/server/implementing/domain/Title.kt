package com.example.server.implementing.domain

import arrow.core.EitherNel
import arrow.core.leftNel
import arrow.core.right
import com.example.server.implementing.util.ValidationError

/**
 * Title object of created article
 */
interface Title {

    /**
     * Title name
     */
    val value: String

    /**
     * Validated title object of a created article
     *
     * @property value
     */
    private data class ValidatedTitle(override val value: String) : Title

    /**
     * Title object without validation of a created article
     */
    private data class TitleWithoutValidation(override val value: String) : Title

    /**
     * Factory method to create a title object
     */
    companion object {
        private const val MAXIMUM_LENGTH = 32

        /**
         * Without validation
         *
         * @param title Title name
         * @return Title object without validation
         */
        fun newWithoutValidation(title: String): Title = TitleWithoutValidation(title)

        /**
         * With validation
         *
         * @param title Title name
         * @return Validated title object of a created article
         */
        fun new(title: String): EitherNel<CreationError, Title> {
            // Do not allow blank title
            if (title.isBlank()) {
                return CreationError.Required.leftNel()
            }
            // Do not allow title longer than the maximum length
            if (title.length > MAXIMUM_LENGTH) {
                return CreationError.TooLong(MAXIMUM_LENGTH).leftNel()
            }

            return ValidatedTitle(title).right()
        }
    }
}

/**
 * The domain rule to create a title object
 */
sealed interface CreationError : ValidationError {

    /**
     * Required
     *
     * Do not allow blank title
     *
     * @constructor Create empty Required
     */
    object Required : CreationError {
        override val message: String
            get() = "title は必須です"
    }

    /**
     * Restriction the length of title
     *
     * Do not allow title longer than the maximum length
     *
     * @property maximumLength
     */
    data class TooLong(val maximumLength: Int) : CreationError {
        override val message: String
            get() = "title は $maximumLength 文字以下にしてください。"
    }
}
