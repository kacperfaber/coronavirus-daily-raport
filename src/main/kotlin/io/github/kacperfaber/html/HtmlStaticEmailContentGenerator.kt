package io.github.kacperfaber.html

import io.github.kacperfaber.ThymeleafContextGenerator
import io.github.kacperfaber.emails.StaticEmailContent
import io.github.kacperfaber.emails.StaticEmailContentGenerator
import io.github.kacperfaber.reports.CovidReport
import io.github.kacperfaber.reports.DailyReport
import io.github.kacperfaber.reports.ReportStorage
import io.github.kacperfaber.thymeleaf.ThymeleafProcessor
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class HtmlStaticEmailContentGenerator(
    var htmlWriter: HtmlWriter,
    var thymeleafProcessor: ThymeleafProcessor,
    var thymeleafContextGenerator: ThymeleafContextGenerator
) : StaticEmailContentGenerator {
    override fun generate(dailyReport: DailyReport, reportStorage: ReportStorage): StaticEmailContent {
        val thymeleafHtml = htmlWriter.write(dailyReport, reportStorage)
        val thymeleafContext = thymeleafContextGenerator.generate(dailyReport)
        val html = thymeleafProcessor.processToHtml(thymeleafHtml, thymeleafContext)
        return StaticEmailContent(html, LocalDateTime.now(), dailyReport.reportDate!!)
    }
}