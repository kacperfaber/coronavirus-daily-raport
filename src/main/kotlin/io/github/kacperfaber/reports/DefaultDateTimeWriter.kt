package io.github.kacperfaber.reports

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DefaultDateTimeWriter : IDateTimeWriter{
    override fun writeDate(l: LocalDateTime): String {
        return "${l.year}-${l.monthValue}-${l.dayOfMonth}"
    }
}