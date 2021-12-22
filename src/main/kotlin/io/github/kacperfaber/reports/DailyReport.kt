package io.github.kacperfaber.reports

import java.time.LocalDate

class DailyReport {
    var reportDate: LocalDate? = null
    lateinit var general: GeneralDailyReport
    lateinit var today: TodayDailyReport
}