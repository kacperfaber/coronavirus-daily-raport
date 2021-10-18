package io.github.kacperfaber.analyzers

import java.time.LocalDate

data class ValueLabel(val value: Long, val name: String, val change: Long, val changedBy: LocalDate) : Element()