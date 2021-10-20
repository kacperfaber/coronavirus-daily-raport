package io.github.kacperfaber.reports

import java.time.LocalDate

class ReportStorage(var reports: Array<Report>) {
    fun getReport(date: LocalDate): Report? {
        return reports.firstOrNull { x -> x.reportDate!! == date }
    }
}