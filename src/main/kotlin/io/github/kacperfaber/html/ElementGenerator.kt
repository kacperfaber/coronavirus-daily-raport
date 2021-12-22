package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport

interface ElementGenerator {
    fun generate(todayCovidReport: CovidReport): EmptyHtmlElement
}