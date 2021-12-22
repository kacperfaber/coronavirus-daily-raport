package io.github.kacperfaber.html

import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component

@Component
class NewDeathsElementGenerator : ElementGenerator {
    override fun generate(dailyReport: DailyReport, reportStorage: ReportStorage): EmptyHtmlElement {
        val newDeaths = dailyReport.today.infections.newDeaths
        return AddThyemelafFragment("New Deaths", newDeaths)
    }
}