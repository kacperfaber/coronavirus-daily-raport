package io.github.kacperfaber.html

import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component

@Component
class DefaultElementsProvider(var elementsGenerators: List<ElementGenerator>) : ElementsProvider {
    override fun provide(dailyReport: DailyReport, reportStorage: ReportStorage): List<EmptyHtmlElement> {
        val elements = ArrayList<EmptyHtmlElement>()
        for (generator in elementsGenerators) {
            elements.add(generator.generate(dailyReport, reportStorage))
        }
        return elements
    }
}