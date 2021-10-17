package io.github.kacperfaber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args : Array<String>) {
    runApplication<Main>(*args)
}

@SpringBootApplication(scanBasePackages = ["io.github.kacperfaber", "io.github.kacperfaber.reports"])
open class Main