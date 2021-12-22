package io.github.kacperfaber.grouping

import java.time.LocalDate

class GroupItem<T : Number>(var date: LocalDate, var value: T)