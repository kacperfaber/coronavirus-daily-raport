package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.ReportStorage

interface HtmlWriter {
    fun write(todayReport: Report): String
}