package io.github.kacperfaber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

fun main(args : Array<String>) {
    runApplication<Main>(*args)
}

@SpringBootApplication(scanBasePackages = ["io.github.kacperfaber", "io.github.kacperfaber.reports"])
@EnableScheduling
open class Main