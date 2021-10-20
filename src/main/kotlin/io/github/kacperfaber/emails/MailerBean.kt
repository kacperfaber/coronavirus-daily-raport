package io.github.kacperfaber.emails

import org.simplejavamail.api.mailer.Mailer
import org.simplejavamail.mailer.MailerBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MailerBean {
    @Bean
    open fun mailer(): Mailer {
        return MailerBuilder
            .withSMTPServer("smtp.gmail.com", 587)
            .withSMTPServerUsername("noconkrystian484@gmail.com")
            .withSMTPServerPassword("HelloWorld1")
            .buildMailer()
    }
}