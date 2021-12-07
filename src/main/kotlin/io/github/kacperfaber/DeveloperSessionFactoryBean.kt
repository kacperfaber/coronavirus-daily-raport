package io.github.kacperfaber

import org.hibernate.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("dev")
open class DeveloperSessionFactoryBean {
    @Bean
    open fun sessionFactory(): SessionFactory {
        return org.hibernate.cfg.Configuration().configure("dev.hibernate.cfg.xml").buildSessionFactory()
    }
}