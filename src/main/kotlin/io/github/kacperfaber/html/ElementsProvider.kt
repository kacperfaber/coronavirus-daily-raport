package io.github.kacperfaber.html

import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage

interface ElementsProvider {
    fun provide(dailyReport: DailyReport, reportStorage: ReportStorage): List<EmptyHtmlElement>
}