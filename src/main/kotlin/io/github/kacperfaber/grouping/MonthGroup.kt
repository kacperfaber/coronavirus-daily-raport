package io.github.kacperfaber.grouping

import java.time.LocalDate

class MonthGroup<T : Number>(var date: LocalDate, items: MutableList<GroupItem<T>>) : Group<T>(items)