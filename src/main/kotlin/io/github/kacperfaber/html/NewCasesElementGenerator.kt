package io.github.kacperfaber.html

import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage
import io.github.kacperfaber.round
import org.springframework.stereotype.Component

@Component
class NewCasesElementGenerator : ElementGenerator {
    override fun generate(dailyReport: DailyReport, reportStorage: ReportStorage): EmptyHtmlElement {
        val newInfections = dailyReport.today.infections.newInfections
        val totalTests = dailyReport.today.tests.tests!!.all
        return PercentThymeleafFragment(
            "New Confirmed Cases",
            newInfections,
            totalTests,
            ((newInfections * 100.0) / totalTests).round(3)
        )
    }
}