package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.api.Subscription
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import java.time.LocalDate
import java.time.LocalDateTime

@Component
class DefaultEmailContextGenerator : EmailContextGenerator {
    override fun generate(subscription: Subscription, html: String, generatedAt: LocalDateTime, reportDate: LocalDate): Context {
        return Context().apply {
            setVariable("subscription", subscription)
            setVariable("staticContent", html)
            setVariable("generatedAt", generatedAt)
            setVariable("reportDate", reportDate)
        }
    }
}