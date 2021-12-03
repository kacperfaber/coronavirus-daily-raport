package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.api.Subscription
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context

@Component
class DefaultEmailContextGenerator : EmailContextGenerator {
    override fun generate(subscription: Subscription, html: String): Context {
        return Context().apply {
            setVariable("subscription", subscription)
        }
    }
}