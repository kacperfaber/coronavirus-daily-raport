package io.github.kacperfaber.emails

import org.simplejavamail.api.mailer.Mailer
import org.springframework.stereotype.Component

@Component
class EmailClient(val mailer: Mailer, val emailGenerator: EmailGenerator, var mailConfiguration: MailConfiguration) {
    fun send(email: String, subject: String, htmlContent: String) {
        mailer.sendMail(emailGenerator.generate(htmlContent, email, mailConfiguration.from, subject))
    }
}