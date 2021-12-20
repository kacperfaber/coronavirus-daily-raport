package io.github.kacperfaber.emails

import org.simplejavamail.api.email.Email
import org.simplejavamail.email.EmailBuilder
import org.springframework.stereotype.Component

@Component
class DefaultEmailGenerator : EmailGenerator {
    override fun generate(htmlContent: String, to: String, from: String, subject: String): Email {
        return EmailBuilder
            .startingBlank()
            .from(from)
            .to(to)
            .withHTMLText(htmlContent)
            .withSubject(subject)
            .buildEmail()
    }
}