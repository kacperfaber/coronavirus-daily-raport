package io.github.kacperfaber.raports

interface JsonReader <T> {
    fun read(str: String): T
}