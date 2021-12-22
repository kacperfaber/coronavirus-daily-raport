package io.github.kacperfaber.reports

interface ReportStorageProvider {
    fun provide(): ReportStorage
}