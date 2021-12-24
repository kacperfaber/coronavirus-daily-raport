package io.github.kacperfaber.emails.tests

import io.github.kacperfaber.emails.DefaultSubjectGenerator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.time.LocalDate
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull

@DisplayName("DefaultSubjectGenerator.generate(LocalDate, Int)")
class DefaultSubjectGenerator_generate_Tests {
    fun exec(date: LocalDate, newInfections: Int) = DefaultSubjectGenerator().generate(date, newInfections)

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec(LocalDate.of(2021, 1, 1), 50) }
    }

    @Test
    fun notNull() {
        assertNotNull(exec(LocalDate.of(2021, 1, 1), 50))
    }

    @Test
    fun notEmpty() {
        assertNotEquals("", exec(LocalDate.of(2021, 1, 1), 50) )
    }
}