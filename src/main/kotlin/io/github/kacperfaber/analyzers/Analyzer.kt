package io.github.kacperfaber.analyzers

import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.ReportStorage

interface Analyzer {
    fun analyze(todayReport: Report, reports: ReportStorage): AnalyzerResult
}