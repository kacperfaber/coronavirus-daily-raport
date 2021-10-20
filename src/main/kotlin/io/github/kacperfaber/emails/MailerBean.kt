package io.github.kacperfaber.emails

import org.simplejavamail.api.mailer.Mailer
import org.simplejavamail.mailer.MailerBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MailerBean {
    @Bean
    open fun mailer(cfg: SmtpConfiguration): Mailer {
        return MailerBuilder
            .withSMTPServer(cfg.host, cfg.port)
            .withSMTPServerUsername(cfg.username)
            .withSMTPServerPassword(cfg.password)
            .buildMailer()
    }
}