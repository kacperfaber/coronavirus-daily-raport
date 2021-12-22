package io.github.kacperfaber

import io.github.kacperfaber.reports.DailyReport
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context

@Component
class DefaultThymeleafContextGenerator : ThymeleafContextGenerator {
    override fun generate(dailyReport: DailyReport): Context {
        return Context().apply { setVariable("today", dailyReport) }
    }
}