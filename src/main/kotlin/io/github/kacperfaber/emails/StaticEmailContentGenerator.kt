package io.github.kacperfaber.emails

import io.github.kacperfaber.reports.CovidReport
import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage

interface StaticEmailContentGenerator {
    fun generate(dailyReport: DailyReport, reportStorage: ReportStorage): StaticEmailContent
}