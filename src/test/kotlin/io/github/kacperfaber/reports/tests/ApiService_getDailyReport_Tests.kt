package io.github.kacperfaber.reports.tests

import io.github.kacperfaber.http.HttpService
import io.github.kacperfaber.reports.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*
import java.util.*
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
@DisplayName("ApiService.getDailyReport()")
class ApiService_getDailyReport_Tests {
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

    fun exec() = ApiService(http, dateTimeWriter, reportsJsonReader, vaccinationsJsonReader, dailyReader).getDailyReport()

    @Test
    fun doesNotThrow() {
        `when`(http.getContent(any())).thenReturn("")
        `when`(dailyReader.read(any())).thenReturn(DailyReport())
        assertDoesNotThrow { exec() }
    }

    @Test
    fun httpGetContentNotGetsNullUrl() {
        `when`(http.getContent(any())).thenReturn("")
        `when`(dailyReader.read(any())).thenReturn(DailyReport())
        exec()
        verify(http).getContent(argThat {x -> x != null})
    }

    @Test
    fun httpGetContentCalledOnce() {
        `when`(http.getContent(any())).thenReturn("")
        `when`(dailyReader.read(any())).thenReturn(DailyReport())
        exec()
        verify(http, times(1)).getContent(any())
    }

    @Test
    fun dailyReaderGetsJsonReturnedByHttpGetContentMethod() {
        val json = UUID.randomUUID().toString()
        `when`(http.getContent(any())).thenReturn(json)
        `when`(dailyReader.read(any())).thenReturn(DailyReport())
        exec()
        verify(dailyReader).read(eq(json))
    }

    @Test
    fun dailyReaderCalledOnce() {
        `when`(http.getContent(any())).thenReturn("")
        `when`(dailyReader.read(any())).thenReturn(DailyReport())
        exec()
        verify(dailyReader, times(1)).read(any())
    }

    @Test
    fun equalsToObjectReturnedByDailyReaderReadMethod() {
        val expected = DailyReport()
        `when`(http.getContent(any())).thenReturn("")
        `when`(dailyReader.read(any())).thenReturn(expected)
        assertEquals(expected, exec())
    }

    fun response(url: String): Response {
        val client = OkHttpClient()
        val request = Request.Builder().url(url)
            .get()
            .build()
        val call = client.newCall(request)
        return call.execute()
    }

    @Test
    fun httpGetContentUrlReturnedOkWhenRequested() {
        `when`(http.getContent(any())).thenReturn("")
        `when`(dailyReader.read(any())).thenReturn(DailyReport())
        exec()
        verify(http).getContent(argThat { x -> response(x).isSuccessful })
    }
}