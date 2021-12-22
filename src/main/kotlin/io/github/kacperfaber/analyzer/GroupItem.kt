package io.github.kacperfaber.analyzer

import java.time.LocalDate

class GroupItem<T : Number>(var date: LocalDate, var value: T)