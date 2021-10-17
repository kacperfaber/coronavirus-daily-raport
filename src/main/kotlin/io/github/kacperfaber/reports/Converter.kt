package io.github.kacperfaber.reports

interface Converter<T, TOut> {
    fun convert(t: T): TOut
}