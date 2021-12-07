package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report
import org.springframework.stereotype.Component

@Component
class DefaultElementsProvider(var elementsGenerators: List<ElementGenerator>) : ElementsProvider {
    override fun provide(todayReport: Report): List<EmptyHtmlElement> {
        val elements = ArrayList<EmptyHtmlElement>()
        for (generator in elementsGenerators) {
            elements.add(generator.generate(todayReport))
        }
        return elements
    }
}