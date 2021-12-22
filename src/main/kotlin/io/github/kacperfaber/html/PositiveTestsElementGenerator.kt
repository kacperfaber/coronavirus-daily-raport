package io.github.kacperfaber.html

import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage
import io.github.kacperfaber.round
import org.springframework.stereotype.Component

@Component
class PositiveTestsElementGenerator : ElementGenerator {
    override fun generate(dailyReport: DailyReport, reportStorage: ReportStorage): EmptyHtmlElement {
        val positive = dailyReport.today.tests.tests!!.positive
        val all = dailyReport.today.tests.tests!!.all
        val percent = ((positive * 100.0) / all).round(3)
        return PercentThymeleafFragment("Positive Tests", positive, all, percent)
    }
}