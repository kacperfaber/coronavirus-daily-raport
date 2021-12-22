package io.github.kacperfaber.html

import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component

@Component
open class DefaultHtmlWriter(
    var elementsProvider: ElementsProvider,
    var elementsSorter: ElementsSorter,
    var elementsWriter: ElementsWriter
) : HtmlWriter {
    override fun write(dailyReport: DailyReport, reportStorage: ReportStorage): String {
        val elements = elementsProvider.provide(dailyReport, reportStorage)
        val sortedElements = elementsSorter.sort(elements)
        return elementsWriter.write(sortedElements)
    }
}