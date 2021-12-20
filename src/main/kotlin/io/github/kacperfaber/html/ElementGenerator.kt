package io.github.kacperfaber.html

import io.github.kacperfaber.reports.Report

interface ElementGenerator {
    fun generate(todayReport: Report): EmptyHtmlElement
}