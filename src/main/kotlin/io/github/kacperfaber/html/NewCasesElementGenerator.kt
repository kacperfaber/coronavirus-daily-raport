package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report
import org.springframework.stereotype.Component

@Component
class NewCasesElementGenerator : ElementGenerator{
    override fun generate(todayReport: Report): EmptyHtmlElement {
        val newInfections = todayReport.today!!.infections!!.newInfections ?: throw NullPointerException()
        return AddThyemelafFragment("New Infections", newInfections)
    }
}