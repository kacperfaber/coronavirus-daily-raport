package io.github.kacperfaber.reports

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ReportStorageBean {
    @Bean
    open fun reportStorage(api: ApiService): ReportStorage {
        return ReportStorage(api.getAllCovidReports(), api.getAllVaccinationReports())
    }
}