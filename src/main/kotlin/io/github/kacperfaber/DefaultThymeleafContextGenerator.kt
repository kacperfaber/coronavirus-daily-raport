package io.github.kacperfaber

import io.github.kacperfaber.reports.Report
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context

@Component
class DefaultThymeleafContextGenerator : ThymeleafContextGenerator {
    override fun generate(todayReport: Report): Context {
        return Context().apply { setVariable("today", todayReport) }
    }
}