package io.github.kacperfaber.reports.tests

import io.github.kacperfaber.http.HttpService
import io.github.kacperfaber.reports.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.verify
import java.time.LocalDate
import java.util.*
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
@DisplayName("ApiService.getCovidReports(LocalDate, LocalDate)")
class ApiService_getCovidReports_Tests {
    @Mock
    lateinit var http: HttpService

    @Mock
    lateinit var dateTimeWriter: IDateTimeWriter

    @Mock
    lateinit var reportsJsonReader: JsonReader<Array<CovidReport>>

    @Mock
    lateinit var vaccinationsJsonReader: JsonReader<Array<VaccinationReport>>

    @Mock
    lateinit var dailyReader: JsonReader<DailyReport>

    fun exec(from: LocalDate, to: LocalDate) = ApiService(http, dateTimeWriter, reportsJsonReader, vaccinationsJsonReader, dailyReader).getCovidReports(from, to)

    @Test
    fun doesNotThrow() {
        `when`(http.getContent(any())).thenReturn("")
        `when`(reportsJsonReader.read(any())).thenReturn(arrayOf())
        assertDoesNotThrow { exec(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 2, 1)) }
    }

    @Test
    fun objectReturnedByReportsJsonReader() {
        val expected = arrayOf(CovidReport(), CovidReport())
        `when`(http.getContent(any())).thenReturn("")
        `when`(reportsJsonReader.read(any())).thenReturn(expected)
        val res = exec(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 2, 1))
        assertEquals(expected, res)
    }

    @Test
    fun reportsJsonReaderGetsStringReturnedByHttpGetContent() {
        val expected = UUID.randomUUID().toString()
        `when`(http.getContent(any())).thenReturn(expected)
        `when`(reportsJsonReader.read(any())).thenReturn(arrayOf())
        exec(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 2, 1))
        verify(reportsJsonReader).read(eq(expected))
    }

    @Test
    fun httpGetContentGetsUrlMatchingToRegex() {
        `when`(http.getContent(any())).thenReturn("")
        `when`(reportsJsonReader.read(any())).thenReturn(arrayOf())
        exec(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 2, 1))
        verify(http).getContent(ArgumentMatchers.matches(""))
    }
}