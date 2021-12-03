package io.github.kacperfaber.html

import io.github.kacperfaber.ThymeleafContextGenerator
import io.github.kacperfaber.emails.StaticEmailContent
import io.github.kacperfaber.emails.StaticEmailContentGenerator
import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.thymeleaf.ThymeleafProcessor
import org.springframework.stereotype.Component

@Component
class HtmlStaticEmailContentGenerator(
    var htmlWriter: HtmlWriter,
    var thymeleafProcessor: ThymeleafProcessor,
    var thymeleafContextGenerator: ThymeleafContextGenerator) : StaticEmailContentGenerator {
    override fun generate(today: Report): StaticEmailContent {
        val thymeleafHtml = htmlWriter.write(today)
        val thymeleafContext = thymeleafContextGenerator.generate(today)
        val html = thymeleafProcessor.processToHtml(thymeleafHtml, thymeleafContext)
        return StaticEmailContent(html)
    }
}