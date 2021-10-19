package io.github.kacperfaber.api

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class DefaultCodeGenerator : CodeGenerator{
    override fun generate(): String {
        return Random.nextInt().toString()
    }
}