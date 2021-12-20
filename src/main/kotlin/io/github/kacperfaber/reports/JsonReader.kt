package io.github.kacperfaber.reports

interface JsonReader<T> {
    fun read(str: String): T
}