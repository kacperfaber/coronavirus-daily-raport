package io.github.kacperfaber

import io.github.kacperfaber.api.SubscriptionRepository
import io.github.kacperfaber.emails.EmailClient
import io.github.kacperfaber.emails.EmailWriter
import io.github.kacperfaber.emails.StaticEmailContentGenerator
import io.github.kacperfaber.emails.SubjectGenerator
import io.github.kacperfaber.history.HistoryRepository
import io.github.kacperfaber.history.HistoryService
import io.github.kacperfaber.html.HtmlWriter
import io.github.kacperfaber.reports.ApiService
import io.github.kacperfaber.thymeleaf.ThymeleafProcessor
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import java.time.LocalDate

@Component
class Worker(
    var api: ApiService,
    var repository: SubscriptionRepository,
    var emailClient: EmailClient,
    var subjectGenerator: SubjectGenerator,
    var historyService: HistoryService,
    var staticEmailContentGenerator: StaticEmailContentGenerator,
    var emailWriter: EmailWriter
) {
    @Scheduled(fixedDelay = (10*60)*1000)
    fun doWork() {
        val today = LocalDate.now()
        if (historyService.getLog(today) == null) {
            val report = api.getReport(today)
            if (report != null) {
                val newInfections = report.today!!.infections!!.newInfections ?: throw NullPointerException()
                val subject = subjectGenerator.generate(report.reportDate!!, newInfections)
                val staticContent = staticEmailContentGenerator.generate(report)
                for (subscription in repository.getActiveSubscriptions()) {
                    val html = emailWriter.write(subscription, staticContent)
                     emailClient.send(subscription.email, subject, html)
                }
                historyService.createLog(today)
            }
        }
    }
}