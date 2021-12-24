package io.github.kacperfaber.thymeleaf.tests

import io.github.kacperfaber.reports.ApiService
import io.github.kacperfaber.reports.CovidReport
import io.github.kacperfaber.reports.VaccinationReport
import io.github.kacperfaber.thymeleaf.DefaultReportStorageProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@DisplayName("DefaultReportStorageProvider.provide()")
class DefaultReportStorageProvider_provide_Tests {
    var api = mock(ApiService::class.java)

    fun exec() = DefaultReportStorageProvider(api).provide()

    @Test
    fun doesNotThrow() {
        `when`(api.getAllCovidReports()).thenReturn(arrayOf())
        `when`(api.getAllVaccinationReports()).thenReturn(arrayOf())
        assertDoesNotThrow { exec() }
    }

    @Test
    fun notNull() {
        `when`(api.getAllCovidReports()).thenReturn(arrayOf())
        `when`(api.getAllVaccinationReports()).thenReturn(arrayOf())
        assertNotNull(exec())
    }

    @Test
    fun covidReportsEqualsToGivenByApiService() {
        val array = arrayOf<CovidReport>()
        `when`(api.getAllCovidReports()).thenReturn(array)
        `when`(api.getAllVaccinationReports()).thenReturn(arrayOf())
        assertEquals(array, exec().covidReports)
    }

    @Test
    fun vaccinationReportsEqualsToGivenByApiService() {
        val array = arrayOf<VaccinationReport>()
        `when`(api.getAllCovidReports()).thenReturn(arrayOf())
        `when`(api.getAllVaccinationReports()).thenReturn(array)
        assertEquals(array, exec().vaccinationReports)
    }
}