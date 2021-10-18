package io.github.kacperfaber.reports

import java.time.LocalDateTime

interface IDateTimeWriter {
    fun writeDate(l: LocalDateTime): String
}