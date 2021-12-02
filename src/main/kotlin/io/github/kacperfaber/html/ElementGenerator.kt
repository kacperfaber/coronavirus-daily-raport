package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.TodayReport

interface ElementGenerator {
    fun generate(todayReport: Report): HtmlElement
}