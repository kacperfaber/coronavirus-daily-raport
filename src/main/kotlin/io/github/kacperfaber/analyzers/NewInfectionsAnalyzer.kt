package io.github.kacperfaber.analyzers

import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component

@Component
class NewInfectionsAnalyzer : Analyzer{
    override fun analyze(todayReport: Report, reports: ReportStorage): AnalyzerResult {
        val todayInfections = todayReport.today!!.infections!!.newInfections ?: throw AnalyzerException()
        return AnalyzerResult(false, IntLabel(Labels.newInfections, todayInfections))
    }
}