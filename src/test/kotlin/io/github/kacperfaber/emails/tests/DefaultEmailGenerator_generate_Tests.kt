package io.github.kacperfaber.emails.tests

import io.github.kacperfaber.emails.DefaultEmailGenerator
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertNotNull

@DisplayName("DefaultEmailGenerator.generate(String, String, String, String)")
class DefaultEmailGenerator_generate_Tests {
    fun exec(htmlContent: String, to: String, from: String, subject: String) =
        DefaultEmailGenerator().generate(htmlContent, to, from, subject)

    @Test
    fun doesNotThrowWhenFromAndToParametersAreGiven() {
        assertDoesNotThrow { exec("", "kacper@gmail.com", "kacper@gmail.com", "") }
    }

    @Test
    fun notNull() {
        assertNotNull(exec("", "kacper@gmail.com", "kacper@gmail.com", ""))
    }
}