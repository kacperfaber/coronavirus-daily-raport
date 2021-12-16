package io.github.kacperfaber.reports

import java.time.LocalDate

class ReportStorage(var reports: Array<Report>, var vaccinationReports: Array<VaccinationReport>) {
    fun getReport(date: LocalDate): Report? {
        return reports.firstOrNull { x -> x.reportDate!! == date }
    }

    fun getVaccinationReport(date: LocalDate): VaccinationReport? {
        return vaccinationReports.firstOrNull {x -> x.reportDate == date}
    }

    fun getVaccinationReports(from: LocalDate, to: LocalDate): List<VaccinationReport> {
        return vaccinationReports.filter { x -> x.reportDate > from && x.reportDate < to }
    }
}