package io.github.kacperfaber.reports.tests

import io.github.kacperfaber.reports.DefaultDateTimeWriter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.random.Random

class DefaultDateTimeWriter_writeDate {
    fun exec(l: LocalDateTime): String {
        return DefaultDateTimeWriter().writeDate(l)
    }
    @Test
    fun doesNotThrow() {
        Assertions.assertDoesNotThrow { exec(LocalDateTime.of(2021, 10, 18, 12, 30, 30)) }
    }
    @Test
    fun startsWithYear() {
        val year = Random.nextInt(2019, 2030)
        val res = exec(LocalDateTime.of(year, 10, 18, 12, 30, 30))
        Assertions.assertTrue(res.startsWith(year.toString()))
    }
    @Test
    fun endsWithDay() {
        val day = Random.nextInt(0,12)
        val res = exec(LocalDateTime.of(2021, 10, day, 12, 30, 30))
        Assertions.assertTrue(res.endsWith(day.toString()))
    }
    @Test
    fun expected() {
        val day = Random.nextInt(1, 28)
        val month = Random.nextInt(12)
        val year = Random.nextInt(2019, 2030)
        val res = exec(LocalDateTime.of(year, month, day, 12, 30, 30))
        Assertions.assertEquals("${year}-${month}-${day}", res)
    }
}