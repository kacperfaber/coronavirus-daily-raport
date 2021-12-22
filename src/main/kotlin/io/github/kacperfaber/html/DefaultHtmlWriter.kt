package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport
import org.springframework.stereotype.Component

@Component
open class DefaultHtmlWriter(
    var elementsProvider: ElementsProvider,
    var elementsSorter: ElementsSorter,
    var elementsWriter: ElementsWriter
) : HtmlWriter {
    override fun write(todayCovidReport: CovidReport): String {
        val elements = elementsProvider.provide(todayCovidReport)
        val sortedElements = elementsSorter.sort(elements)
        return elementsWriter.write(sortedElements)
    }
}