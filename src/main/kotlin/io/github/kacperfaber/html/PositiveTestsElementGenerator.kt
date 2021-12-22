package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport
import io.github.kacperfaber.round
import org.springframework.stereotype.Component

@Component
class PositiveTestsElementGenerator : ElementGenerator {
    override fun generate(todayCovidReport: CovidReport): EmptyHtmlElement {
        val positive = todayCovidReport.today!!.tests!!.tests!!.positive
        val all = todayCovidReport.today!!.tests!!.tests!!.all
        val percent = ((positive * 100.0) / all).round(3)
        return PercentThymeleafFragment("Positive Tests", positive, all, percent)
    }
}