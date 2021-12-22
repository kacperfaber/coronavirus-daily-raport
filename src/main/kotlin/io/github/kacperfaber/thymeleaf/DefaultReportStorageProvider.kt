package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.reports.ApiService
import io.github.kacperfaber.reports.ReportStorage
import io.github.kacperfaber.reports.ReportStorageProvider
import org.springframework.stereotype.Component

@Component
class DefaultReportStorageProvider(var api: ApiService) : ReportStorageProvider{
    override fun provide(): ReportStorage {
        return ReportStorage(api.getAllCovidReports(), api.getAllVaccinationReports())
    }
}