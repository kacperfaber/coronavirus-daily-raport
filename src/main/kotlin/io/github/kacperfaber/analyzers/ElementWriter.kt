package io.github.kacperfaber.analyzers

interface ElementWriter {
    fun verify(cl: Class<Any>): Boolean
    fun write(): String
}