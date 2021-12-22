package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport

interface HtmlWriter {
    fun write(todayCovidReport: CovidReport): String
}