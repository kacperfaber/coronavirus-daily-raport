package io.github.kacperfaber

import io.github.kacperfaber.reports.ApiService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class Worker(var api: ApiService) {
    @Scheduled(fixedDelay = 100000)
    fun doWork() {
        val report = api.getReport(LocalDateTime.now())
        val allReports = api.getAllReports()
        // TODO: End it
    }
}