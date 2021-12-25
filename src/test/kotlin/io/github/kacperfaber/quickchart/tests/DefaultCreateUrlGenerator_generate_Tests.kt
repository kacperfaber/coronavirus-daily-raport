package io.github.kacperfaber.quickchart.tests

import io.github.kacperfaber.quickchart.DefaultCreateUrlGenerator
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@DisplayName("DefaultCreateUrlGenerator.generate()")
class DefaultCreateUrlGenerator_generate_Tests {
    fun exec() = DefaultCreateUrlGenerator().generate()

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec() }
    }

    @Test
    fun notEmpty() {
        assertNotEquals("", exec())
    }

    @Test
    fun notNull() {
        assertNotNull(exec())
    }

    @Test
    fun startsWithHttps() {
        assertTrue(exec().startsWith("https"))
    }

    @Test
    fun returnsJsonWhenRequested() {
        val http = OkHttpClient()
        val request = Request.Builder().get().url(exec()).build()
        val response = http.newCall(request).execute()
        assertEquals("application/json", response.header("Content-Type"))
    }
}