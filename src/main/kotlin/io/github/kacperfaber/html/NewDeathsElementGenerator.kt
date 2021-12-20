package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report
import org.springframework.stereotype.Component

@Component
class NewDeathsElementGenerator : ElementGenerator {
    override fun generate(todayReport: Report): EmptyHtmlElement {
        val newDeaths = todayReport.today!!.infections!!.newDeaths ?: throw NullPointerException()
        return AddThyemelafFragment("New Deaths", newDeaths)
    }
}