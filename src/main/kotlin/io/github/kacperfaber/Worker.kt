package io.github.kacperfaber

import io.github.kacperfaber.api.SubscriptionRepository
import io.github.kacperfaber.emails.EmailClient
import io.github.kacperfaber.emails.EmailWriter
import io.github.kacperfaber.emails.SubjectGenerator
import io.github.kacperfaber.history.HistoryRepository
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
    var historyRepository: HistoryRepository,
    var htmlWriter: HtmlWriter,
    var thymeleafProcessor: ThymeleafProcessor,
    var thymeleafContextGenerator: ThymeleafContextGenerator
) {
    @Scheduled(fixedDelay = 1000)
    fun doWork() {
        val today = LocalDate.now()
        if (historyRepository.getLog(today) != null) {
            val report = api.getReport(today)
            if (report != null) {
                val newInfections = report.today!!.infections!!.newInfections ?: throw NullPointerException()
                val subject = subjectGenerator.generate(report.reportDate!!, newInfections)
                for (email in repository.getActiveEmails()) {
                    val thymeleafHtml = htmlWriter.write(report)
                    val thymeleafContext = thymeleafContextGenerator.generate(report)
                    val html = thymeleafProcessor.processToHtml(thymeleafHtml, thymeleafContext)
                    emailClient.send(email, subject, html)
                }
            }
        }
    }
}