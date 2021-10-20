package io.github.kacperfaber.emails

import org.simplejavamail.api.email.Email

interface EmailGenerator {
    fun generate(htmlContent: String, to: String, from: String, subject: String): Email
}