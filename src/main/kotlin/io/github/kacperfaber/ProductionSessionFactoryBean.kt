package io.github.kacperfaber

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.util.*

@Configuration
@Profile("prod")
open class ProductionSessionFactoryBean {
    @Value("\${hibernate.connectionUrl}")
    lateinit var connectionUrl: String

    @Value("\${hibernate.password}")
    lateinit var password: String

    @Value("\${hibernate.username}")
    lateinit var username: String

    @Value("\${hibernate.showSql:true}")
    lateinit var showSql: String

    @Value("\${hibernate.dialect:org.hibernate.dialect.MySQL57Dialect}")
    lateinit var dialect: String

    @Value("\${hibernate.hbm2dllAuto:update}")
    lateinit var hbm2dllAuto: String

    @Value("\${hibernate.driverClass:com.mysql.jdbc.Driver}")
    lateinit var driverClass: String

    @Value("\${hibernate.currentSessionContextClass:thread}")
    lateinit var currentSessionContextClass: String

    @Bean
    open fun productionSessionFactory(): SessionFactory {
        val properties = Properties().apply {
            setProperty("hibernate.connection.url", connectionUrl)
            setProperty("hibernate.connection.username", username)
            setProperty("hibernate.connection.password", password)
            setProperty("hibernate.current_session_context_class", currentSessionContextClass)
            setProperty("hibernate.connection.driver_class", driverClass)
            setProperty("hibernate.dialect", dialect)
            setProperty("hibernate.show_sql", showSql)
            setProperty("hibernate.hbm2ddl.auto", hbm2dllAuto)
        }
        return org.hibernate.cfg.Configuration().addProperties(properties).buildSessionFactory()
    }
}