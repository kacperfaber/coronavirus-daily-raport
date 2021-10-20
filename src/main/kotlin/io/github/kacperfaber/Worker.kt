package io.github.kacperfaber

import io.github.kacperfaber.api.SubscriptionRepository
import io.github.kacperfaber.emails.EmailClient
import io.github.kacperfaber.emails.EmailWriter
import io.github.kacperfaber.emails.SubjectGenerator
import io.github.kacperfaber.reports.ApiService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime

@Component
class Worker(var api: ApiService, var repository: SubscriptionRepository, var emailWriter: EmailWriter, var emailClient: EmailClient, var subjectGenerator: SubjectGenerator) {
    @Scheduled(fixedDelay = 1000)
    fun doWork() {
        val report = api.getReport()
        if (report != null) {
            val newInfections = report.today!!.infections!!.newInfections ?: throw NullPointerException()
            val subject = subjectGenerator.generate(report.reportDate!!.toLocalDate(), newInfections)
            for (email in repository.getActiveEmails()) {
                val html = emailWriter.write(report)
                emailClient.send(email, subject, html)
            }
        }
        return
    }
}