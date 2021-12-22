package io.github.kacperfaber.html

import io.github.kacperfaber.reports.CovidReport

interface ElementsProvider {
    fun provide(todayCovidReport: CovidReport): List<EmptyHtmlElement>
}