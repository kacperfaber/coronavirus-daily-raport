package io.github.kacperfaber.raports

interface Converter<T, TOut> {
    fun convert(t: T): TOut
}