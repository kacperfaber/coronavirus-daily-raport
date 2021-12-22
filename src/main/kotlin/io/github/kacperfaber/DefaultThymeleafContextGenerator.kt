package io.github.kacperfaber

import io.github.kacperfaber.reports.CovidReport
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context

@Component
class DefaultThymeleafContextGenerator : ThymeleafContextGenerator {
    override fun generate(todayCovidReport: CovidReport): Context {
        return Context().apply { setVariable("today", todayCovidReport) }
    }
}