package io.github.kacperfaber.analyzer

import io.github.kacperfaber.grouping.MonthGroup
import java.time.LocalDate

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