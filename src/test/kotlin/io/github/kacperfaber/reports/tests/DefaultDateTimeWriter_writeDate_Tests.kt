package io.github.kacperfaber.reports.tests

import io.github.kacperfaber.reports.DefaultDateTimeWriter
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.time.LocalDate
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@DisplayName("DefaultDateTimeWriter.writeDate(LocalDate)")
class DefaultDateTimeWriter_writeDate_Tests {
    fun exec(date: LocalDate) = DefaultDateTimeWriter().writeDate(date)

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec(LocalDate.of(2021, 1, 1)) }
    }

    @Test
    fun notNull() {
        assertNotNull(exec(LocalDate.of(2021, 1, 1)))
    }

    @Test
    fun notEmpty() {
        assertNotEquals("", exec(LocalDate.of(2021, 1, 1)))
    }

    @Test
    fun containsYear() {
        val year = 2021
        val res = exec(LocalDate.of(year, 1, 1))
        assertTrue(res.contains(year.toString()))
    }

    @Test
    fun containsMonth() {
        val month = 10
        val res = exec(LocalDate.of(2021, month, 1))
        assertTrue(res.contains(month.toString()))
    }

    @Test
    fun containsDay() {
        val day = 25
        val res = exec(LocalDate.of(2021, 5, 25))
        assertTrue(res.contains(day.toString()))
    }
}