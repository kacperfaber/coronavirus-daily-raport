package io.github.kacperfaber.analyzers

import io.github.kacperfaber.reports.Report

interface Analyzer {
    fun analyze(todayReport: Report, reports: Array<Report>): AnalyzerResult
}