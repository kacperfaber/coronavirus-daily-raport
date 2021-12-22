package io.github.kacperfaber

import io.github.kacperfaber.reports.DailyReport
import org.thymeleaf.context.Context

interface ThymeleafContextGenerator {
    fun generate(dailyReport: DailyReport): Context
}