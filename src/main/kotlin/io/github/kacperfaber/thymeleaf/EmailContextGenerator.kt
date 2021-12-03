package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.api.Subscription
import org.thymeleaf.context.Context

interface EmailContextGenerator {
    fun generate(subscription: Subscription, html: String): Context
}