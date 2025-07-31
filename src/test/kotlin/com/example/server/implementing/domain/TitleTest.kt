package com.example.server.implementing.domain

import arrow.core.Either
import net.jqwik.api.Arbitraries
import net.jqwik.api.Arbitrary
import net.jqwik.api.ArbitrarySupplier
import net.jqwik.api.ForAll
import net.jqwik.api.From
import net.jqwik.api.Property
import org.assertj.core.api.Assertions.assertThat

class TitleTest {
    class New {
        @Property
        fun `正常系-長さが有効な場合、検証済みの Title が戻り値`(
            @ForAll @From(supplier = TitleValidRange::class) validString: String,
        ) {
            /**
             * given:
             */

            /**
             * when:
             */
            val actual = Title.new(validString)

            /**
             * then:
             */
            val expected = Title.newWithoutValidation(validString)
            when (actual) {
                is Either.Left -> assert(false) { "原因: ${actual.value}" }
                is Either.Right -> assertThat(actual.value.value).isEqualTo(expected.value)
            }
        }
    }

    class TitleValidRange : ArbitrarySupplier<String> {
        override fun get(): Arbitrary<String> {
            return Arbitraries.strings().ofMinLength(1).ofMaxLength(32).filter { it.isNotBlank() }
        }
    }
}
