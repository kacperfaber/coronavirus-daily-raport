package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport
import org.springframework.stereotype.Component

@Component
class DefaultElementsProvider(var elementsGenerators: List<ElementGenerator>) : ElementsProvider {
    override fun provide(todayCovidReport: CovidReport): List<EmptyHtmlElement> {
        val elements = ArrayList<EmptyHtmlElement>()
        for (generator in elementsGenerators) {
            elements.add(generator.generate(todayCovidReport))
        }
        return elements
    }
}