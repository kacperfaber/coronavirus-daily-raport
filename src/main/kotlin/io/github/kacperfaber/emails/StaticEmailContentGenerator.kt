package io.github.kacperfaber.emails

import io.github.kacperfaber.reports.Report

interface StaticEmailContentGenerator {
    fun generate(today: Report): StaticEmailContent
}