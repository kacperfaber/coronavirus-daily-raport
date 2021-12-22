package io.github.kacperfaber.analyzer

import io.github.kacperfaber.grouping.MonthGroup
import java.time.LocalDate

fun <TKey, TVal> List<MonthGroup<Int>>.average(key: (LocalDate) -> TKey, value: (Double) -> TVal): HashMap<TKey, TVal> {
    val res = hashMapOf<TKey, TVal>()
    for (m in this) {
        var total = 0
        for (item in m.items) {
            total += item.value
        }
        res[key(m.date)] = value((total / m.items.count()).toDouble())
    }
    return res
}

fun List<MonthGroup<Int>>.average(): HashMap<LocalDate, Double> {
    val res = hashMapOf<LocalDate, Double>()
    for (m in this) {
        var total = 0
        for (item in m.items) {
            total += item.value
        }
        res[m.date] = (total / m.items.count()).toDouble()
    }
    return res
}