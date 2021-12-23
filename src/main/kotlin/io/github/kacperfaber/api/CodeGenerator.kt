package io.github.kacperfaber.api

interface CodeGenerator {
    fun generate(len: Int): String
}