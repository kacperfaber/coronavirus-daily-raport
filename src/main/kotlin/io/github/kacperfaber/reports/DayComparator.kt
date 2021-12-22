package io.github.kacperfaber.reports

import java.time.LocalDate
import java.time.LocalDateTime

interface DayComparator {
    fun compare(now: LocalDate, today: LocalDate): Boolean
}