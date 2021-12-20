package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.api.Subscription
import io.github.kacperfaber.emails.EmailWriter
import io.github.kacperfaber.emails.StaticEmailContent
import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context

@Component
class ThymeleafEmailWriter(var engine: TemplateEngine, var emailContextGenerator: EmailContextGenerator) : EmailWriter {
    override fun write(subscription: Subscription, content: StaticEmailContent): String {
        val context = emailContextGenerator.generate(subscription, content.html, content.generatedAt, content.reportDate)
        return engine.process("email", context)
    }
}