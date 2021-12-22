package io.github.kacperfaber.grouping

import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

fun <T : Number> HashMap<LocalDate, T>.weeks(): List<WeekGroup<T>> {
    val res = mutableListOf<WeekGroup<T>>()
    val weekFields = WeekFields.of(Locale.getDefault())
    for (d in this) {
        val f = weekFields.weekOfWeekBasedYear()
        val group =
            res.find { x -> x.date.monthValue == d.key.monthValue && x.date.year == d.key.year && x.date.get(f) == d.key.get(f) }
        if (group == null) {
            res.add(WeekGroup(d.key, mutableListOf(GroupItem(d.key, d.value))))
        } else {
            group.items.add(GroupItem(d.key, d.value))
        }
    }
    return res
}

fun <T : Number> HashMap<LocalDate, T>.months(): List<MonthGroup<T>> {
    val res = mutableListOf<MonthGroup<T>>()
    for (d in this) {
        val group = res.find { x -> x.date.monthValue == d.key.monthValue && x.date.year == d.key.year }
        if (group == null) {
            res.add(MonthGroup(d.key, mutableListOf(GroupItem(d.key, d.value))))
        } else {
            group.items.add(GroupItem(d.key, d.value))
        }
    }
    return res
}

fun <T : Number> HashMap<LocalDate, T>.years(): List<YearGroup<T>> {
    val res = mutableListOf<YearGroup<T>>()
    for (d in this) {
        val group = res.find { x -> x.date.year == d.key.year }
        if (group == null) {
            res.add(YearGroup(d.key, mutableListOf(GroupItem(d.key, d.value))))
        } else {
            group.items.add(GroupItem(d.key, d.value))
        }
    }
    return res
}

fun <T : Number, TObj : Any> List<TObj>.months(getDate: (TObj) -> LocalDate, getValue: (TObj) -> T): List<MonthGroup<T>> {
    val map = HashMap<LocalDate, T>()
    for (item in this) {
        val date = getDate(item)
        val value = getValue(item)
        map[date] = value
    }
    return map.months()
}

fun <T : Number, TObj : Any> List<TObj>.years(getDate: (TObj) -> LocalDate, getValue: (TObj) -> T): List<YearGroup<T>> {
    val map = HashMap<LocalDate, T>()
    for (item in this) {
        val date = getDate(item)
        val value = getValue(item)
        map[date] = value
    }
    return map.years()
}

fun <T : Number, TObj : Any> List<TObj>.weeks(getDate: (TObj) -> LocalDate, getValue: (TObj) -> T): List<WeekGroup<T>> {
    val map = HashMap<LocalDate, T>()
    for (item in this) {
        val date = getDate(item)
        val value = getValue(item)
        map[date] = value
    }
    return map.weeks()
}