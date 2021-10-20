package io.github.kacperfaber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.scheduling.annotation.EnableScheduling

fun main(args : Array<String>) {
    runApplication<Main>(*args)
}

@SpringBootApplication(scanBasePackages = ["io.github.kacperfaber", "io.github.kacperfaber.reports", "io.github.kacperfaber.api"])
@EnableScheduling
open class Main