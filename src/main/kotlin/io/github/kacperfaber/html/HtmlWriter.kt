package io.github.kacperfaber.html

import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage

interface HtmlWriter {
    fun write(dailyReport: DailyReport, reportStorage: ReportStorage): String
}