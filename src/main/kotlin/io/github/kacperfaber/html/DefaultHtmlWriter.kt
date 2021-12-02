package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report
import org.springframework.stereotype.Component

@Component
open class DefaultHtmlWriter(var elementsProvider: ElementsProvider, var elementsSorter: ElementsSorter, var elementsWriter: ElementsWriter) : HtmlWriter{
    override fun write(todayReport: Report): String {
        val elements = elementsProvider.provide(todayReport)
        val sortedElements = elementsSorter.sort(elements)
        return elementsWriter.write(sortedElements)
    }
}