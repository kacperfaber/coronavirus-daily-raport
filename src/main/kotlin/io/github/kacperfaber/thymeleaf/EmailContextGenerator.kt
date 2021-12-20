package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.api.Subscription
import org.thymeleaf.context.Context
import java.time.LocalDate
import java.time.LocalDateTime

interface EmailContextGenerator {
    fun generate(subscription: Subscription, html: String, generatedAt: LocalDateTime, reportDate: LocalDate): Context
}