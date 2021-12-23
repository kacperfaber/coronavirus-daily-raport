package io.github.kacperfaber.api.tests

import io.github.kacperfaber.api.DefaultCodeGenerator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@DisplayName("DefaultCodeGenerator.generate(int): String")
class DefaultCodeGenerator_generate_Tests {
    fun exec(len: Int) = DefaultCodeGenerator().generate(len)

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec(5) }
    }

    @ParameterizedTest
    @CsvSource("5", "10", "15", "20", "125")
    fun expectedLength(expected: Int) {
        assertEquals(expected, exec(expected).length)
    }

    @Test
    fun differentStringsAllTheTime() {
        val s1 = exec(5)
        val s2 = exec(5)
        assertNotEquals(s1, s2)
    }
}