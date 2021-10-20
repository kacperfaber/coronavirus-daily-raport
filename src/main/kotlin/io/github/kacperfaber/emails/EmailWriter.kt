package io.github.kacperfaber.emails

import io.github.kacperfaber.reports.Report

interface EmailWriter {
    fun write(report: Report): String
}