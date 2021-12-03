package io.github.kacperfaber.emails

import io.github.kacperfaber.api.Subscription

interface EmailWriter {
    fun write(subscription: Subscription, content: StaticEmailContent): String
}