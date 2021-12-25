package io.github.kacperfaber.history.tests

import io.github.kacperfaber.history.HistoryLog
import io.github.kacperfaber.history.HistoryRepository
import io.github.kacperfaber.history.HistoryService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.argThat
import org.mockito.kotlin.verify
import java.time.LocalDate
import kotlin.test.assertEquals

@DisplayName("HistoryService.createLog(LocalDate)")
@ExtendWith(MockitoExtension::class)
class HistoryService_createLog_Tests {
    @Mock
    lateinit var repo: HistoryRepository

    fun exec(date: LocalDate) = HistoryService(repo).createLog(date)

    @Test
    fun doesNotThrow() {
        `when`(repo.put(any())).thenReturn(HistoryLog())
        assertDoesNotThrow { exec(LocalDate.of(2021, 1, 1)) }
    }

    @Test
    fun repoPutGetsHistoryLogWithGivenLocalDate() {
        val date = LocalDate.of(2021, 1, 1)
        `when`(repo.put(any())).thenReturn(HistoryLog())
        exec(date)
        verify(repo).put(argThat { x -> x.date == date })
    }

    @Test
    fun objectReturnedByRepoPut() {
        val expected = HistoryLog().apply { id = 50 }
        `when`(repo.put(any())).thenReturn(expected)
        assertEquals(expected, exec(LocalDate.of(2021, 1, 1)))
    }
}