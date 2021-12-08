package io.github.kacperfaber

import com.jcraft.jsch.JSch
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SshSessionFactory {
    @Value("\${ssh.username}")
    lateinit var username: String

    @Value("\${ssh.password}")
    lateinit var password: String

    @Value("\${ssh.host}")
    lateinit var host: String

    @Bean
    open fun sshSessionFactoryBean() {
        val sess = JSch().getSession(username, host)
        sess.setPassword(password)
        sess.connect()
    }
}