package io.github.kacperfaber

import io.github.kacperfaber.reports.Report
import org.thymeleaf.context.Context

interface ThymeleafContextGenerator {
    fun generate(todayReport: Report): Context
}