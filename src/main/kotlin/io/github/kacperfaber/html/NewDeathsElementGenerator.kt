package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport
import org.springframework.stereotype.Component

@Component
class NewDeathsElementGenerator : ElementGenerator {
    override fun generate(todayCovidReport: CovidReport): EmptyHtmlElement {
        val newDeaths = todayCovidReport.today!!.newDeaths
        return AddThyemelafFragment("New Deaths", newDeaths)
    }
}