package io.github.kacperfaber.reports

import java.time.LocalDate

class VaccinationReport {
    lateinit var reportDate: LocalDate
    lateinit var general: GeneralVaccinationReport
    lateinit var today: TodayVaccinationReport
}