package io.github.kacperfaber.reports

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DefaultDayComparator : DayComparator{
    override fun compare(now: LocalDate, today: LocalDate): Boolean {
        return (today.year == now.year) && (today.month == now.month) && (today.dayOfMonth == today.dayOfMonth)
    }
}