package io.github.kacperfaber.emails

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SmtpConfigurationBean {
    @Value("smtp.username")
    lateinit var username: String

    @Value("smtp.password")
    lateinit var password: String

    @Value("smtp.host")
    lateinit var host: String

    @Value("smtp.port")
    var port: Int = 0

    @Bean
    open fun smtpConfiguration(): SmtpConfiguration {
        return SmtpConfiguration(host, port, username, password)
    }
}