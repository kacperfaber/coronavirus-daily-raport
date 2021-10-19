package io.github.kacperfaber.analyzers

interface ElementWriter<T> where T : Element {
    fun write(element: T): String
}