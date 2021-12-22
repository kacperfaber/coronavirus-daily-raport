package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport
import io.github.kacperfaber.round
import org.springframework.stereotype.Component

@Component
class NewCasesElementGenerator : ElementGenerator {
    override fun generate(todayCovidReport: CovidReport): EmptyHtmlElement {
        val newInfections = todayCovidReport.today!!.newInfections ?: throw NullPointerException()
        val totalTests = todayCovidReport.today!!.tests!!.tests!!.all // TODO: Missing tests
        return PercentThymeleafFragment(
            "New Confirmed Cases",
            newInfections,
            totalTests,
            ((newInfections * 100.0) / totalTests).round(3)
        )
    }
}