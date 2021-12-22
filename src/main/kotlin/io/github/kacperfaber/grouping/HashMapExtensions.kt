package io.github.kacperfaber.grouping

import kotlin.collections.HashMap

fun <T1, T2, TObj> List<TObj>.toHashMap(getDate: (TObj) -> T1, getValue: (TObj) -> T2): HashMap<T1, T2> {
    val map = HashMap<T1, T2>()
    for (item in this) {
        val date = getDate(item)
        val value = getValue(item)
        map[date] = value
    }
    return map
}