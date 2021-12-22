package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport
import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage

interface ElementGenerator {
    fun generate(dailyReport: DailyReport, reportStorage: ReportStorage): EmptyHtmlElement
}