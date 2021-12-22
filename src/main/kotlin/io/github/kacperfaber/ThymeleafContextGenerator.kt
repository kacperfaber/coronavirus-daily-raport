package io.github.kacperfaber

import io.github.kacperfaber.reports.CovidReport
import org.thymeleaf.context.Context

interface ThymeleafContextGenerator {
    fun generate(todayCovidReport: CovidReport): Context
}