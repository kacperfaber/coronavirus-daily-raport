package io.github.kacperfaber.http.tests

import io.github.kacperfaber.http.HttpService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull

@DisplayName("HttpService.getContent(String)")
class HttpService_getContent_Tests {
    fun exec(url: String) = HttpService().getContent(url)

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec("https://reqres.in/api/users/2") }
    }
    
    @Test
    fun notNull() {
        assertNotNull(exec("https://reqres.in/api/users/2"))
    }
    
    @Test
    fun notEmpty() {
        assertNotEquals("", exec("https://reqres.in/api/users/2"))
    }

    @ParameterizedTest
    @CsvSource("https://reqres.in/api/users/2, reqres.in_api_users_2")
    fun equalsToResource(url: String, resource: String) {
        val res = exec("https://reqres.in/api/users/2")
        assertEquals(res, javaClass.classLoader.getResourceAsStream(resource)!!.reader().readText())
    }
}