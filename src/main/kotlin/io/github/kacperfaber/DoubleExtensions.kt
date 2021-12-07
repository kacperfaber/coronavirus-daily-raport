package io.github.kacperfaber
import kotlin.math.*

fun Double.round(d: Int): Double {
    var m = 1.0
    repeat(d) { m *= 10 }
    return round(this * m) / m
}