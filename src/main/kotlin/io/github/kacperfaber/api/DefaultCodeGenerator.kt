package io.github.kacperfaber.api

import org.springframework.stereotype.Component

@Component
class DefaultCodeGenerator : CodeGenerator {
    override fun generate(len: Int): String {
        val builder = StringBuilder()
        val rand = java.util.Random()
        repeat(len) {builder.append(rand.nextInt())}
        return builder.toString()
    }
}