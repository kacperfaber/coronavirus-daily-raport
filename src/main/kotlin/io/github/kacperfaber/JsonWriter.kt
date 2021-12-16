package io.github.kacperfaber

interface JsonWriter<T> {
    fun write(t: T): String
}