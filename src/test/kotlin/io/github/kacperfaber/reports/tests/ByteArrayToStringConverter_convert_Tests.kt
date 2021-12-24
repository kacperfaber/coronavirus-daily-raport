package io.github.kacperfaber.reports.tests

import io.github.kacperfaber.reports.ByteArrayToStringConverter
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull

@DisplayName("ByteArrayToStringConverter.convert(ByteArray)")
class ByteArrayToStringConverter_convert_Tests {
    fun exec(byteArray: ByteArray) = ByteArrayToStringConverter().convert(byteArray)

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec("Hello World".toByteArray()) }
    }

    @Test
    fun notNull() {
        assertNotNull(exec("Hello World".toByteArray()))
    }

    @Test
    fun notEmpty() {
        assertNotEquals("", exec("Hello World".toByteArray()))
    }

    @ParameterizedTest
    @CsvSource("Hello World", "12345", "!@#$%^&*()", "Hello 12345 !@#$%^&*()")
    fun expected(str: String) {
        assertEquals(str, exec(str.toByteArray()))
    }
}