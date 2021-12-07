package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report

interface ElementsProvider {
    fun provide(todayReport: Report): List<EmptyHtmlElement>
}