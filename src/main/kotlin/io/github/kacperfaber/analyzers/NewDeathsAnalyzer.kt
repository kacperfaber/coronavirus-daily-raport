package io.github.kacperfaber.analyzers

import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component

@Component
class NewDeathsAnalyzer : Analyzer{
    override fun analyze(todayReport: Report, reports: ReportStorage): AnalyzerResult {
        val label = IntLabel(Labels.newDeaths, todayReport.today!!.infections!!.newDeaths ?: throw AnalyzerException())
        return AnalyzerResult(false, label)
    }
}