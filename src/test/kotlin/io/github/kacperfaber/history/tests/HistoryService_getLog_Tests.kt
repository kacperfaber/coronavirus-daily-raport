package io.github.kacperfaber.history.tests

import io.github.kacperfaber.history.HistoryLog
import io.github.kacperfaber.history.HistoryRepository
import io.github.kacperfaber.history.HistoryService
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.anyOrNull
import java.time.LocalDate

@DisplayName("HistoryService.getLog(LocalDate)")
class HistoryService_getLog_Tests {
    var repo = mock(HistoryRepository::class.java)

    fun exec(date: LocalDate): HistoryLog? {
        return HistoryService(repo).getLog(date)
    }

    @Test
    fun doesNotThrow() {
        `when`(repo.getLog(LocalDate.of(2021, 1, 1))).thenReturn(null)
        assertDoesNotThrow { exec(LocalDate.of(2021, 1, 1)) }
    }

    @Test
    fun nullIfHistoryRepositoryReturnedNull() {
        `when`(repo.getLog(anyOrNull())).thenReturn(null)
        assertEquals(null, exec(LocalDate.of(2021, 1, 1)))
    }

    @Test
    fun equalsToReturnedByHistoryRepository() {
        val expected = HistoryLog().apply { id = 50 }
        `when`(repo.getLog(anyOrNull())).thenReturn(expected)
        assertEquals(expected, exec(LocalDate.of(2021, 1, 1)))
    }

    @Test
    fun historyRepositoryGetsLocalDateGivenToService() {
        `when`(repo.getLog(anyOrNull())).thenReturn(null)
        exec(LocalDate.of(2021, 1, 1))
        verify(repo).getLog(LocalDate.of(2021, 1, 1))
    }
}