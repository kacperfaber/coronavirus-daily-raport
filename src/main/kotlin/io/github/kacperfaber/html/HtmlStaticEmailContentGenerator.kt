package io.github.kacperfaber.html

import io.github.kacperfaber.emails.StaticEmailContent
import io.github.kacperfaber.emails.StaticEmailContentGenerator
import io.github.kacperfaber.reports.Report
import org.springframework.stereotype.Component

@Component
class HtmlStaticEmailContentGenerator(var htmlWriter: HtmlWriter) : StaticEmailContentGenerator{
    override fun generate(today: Report): StaticEmailContent = StaticEmailContent(htmlWriter.write(today))
}