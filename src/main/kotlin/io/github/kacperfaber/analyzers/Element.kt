package io.github.kacperfaber.analyzers

abstract class Element {
    abstract fun defaultWriter(): Class<out ElementWriter<out Element>>
}