package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report

interface HtmlWriter {
    fun write(todayReport: Report): String
}