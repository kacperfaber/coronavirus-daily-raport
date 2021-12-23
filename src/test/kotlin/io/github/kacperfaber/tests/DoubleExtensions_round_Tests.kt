package io.github.kacperfaber.tests

import io.github.kacperfaber.round
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@DisplayName("Double.round(int)")
class DoubleExtensions_round_Tests {
    fun exec(d: Double, r: Int) = d.round(r)

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec(0.111, 1) }
    }

    @Test
    fun valueIsChanged() {
        val original = 0.2452
        val res = exec(original, 1)
        assertNotEquals(original, res)
    }

    @Test
    fun stringLengthIsChanged() {
        val original = 0.2452
        val res = exec(original, 1)
        assertNotEquals(original.toString().length, res.toString().length)
    }

    @ParameterizedTest
    @CsvSource("0.1, 1, 0.1", "0.2525, 1, 0.3", "1.52525, 1, 1.5", "0.4242, 2, 0.42", "3.5152, 2, 3.52", "15.5555, 3, 15.556", "1.05, 0, 1")
    fun expectedValue(original: Double, round: Int, expected: Double) {
        assertEquals(expected, exec(original, round))
    }
}