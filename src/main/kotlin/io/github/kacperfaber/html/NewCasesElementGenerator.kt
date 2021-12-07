package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.round
import org.springframework.stereotype.Component

@Component
class NewCasesElementGenerator : ElementGenerator{
    override fun generate(todayReport: Report): EmptyHtmlElement {
        val newInfections = todayReport.today!!.infections!!.newInfections ?: throw NullPointerException()
        val totalTests = todayReport.today!!.tests!!.tests!!.all
        return PercentThymeleafFragment("New Confirmed Cases", newInfections, totalTests, ((newInfections*100.0)/totalTests).round(3))
    }
}