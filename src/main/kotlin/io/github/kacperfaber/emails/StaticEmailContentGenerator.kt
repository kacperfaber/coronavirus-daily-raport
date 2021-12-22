package io.github.kacperfaber.emails

import io.github.kacperfaber.reports.CovidReport

interface StaticEmailContentGenerator {
    fun generate(today: CovidReport): StaticEmailContent
}