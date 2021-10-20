package io.github.kacperfaber.emails

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MailConfigurationBean {
    @Value("\${mail.from}")
    lateinit var from: String

    @Bean
    open fun mailConfiguration(): MailConfiguration {
        return MailConfiguration(from)
    }
}