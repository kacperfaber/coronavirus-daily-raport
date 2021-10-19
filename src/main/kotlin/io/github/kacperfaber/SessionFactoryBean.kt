package io.github.kacperfaber

import org.hibernate.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SessionFactoryBean {
    @Bean
    open fun sessionFactory(): SessionFactory {
        return org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory()
    }
}