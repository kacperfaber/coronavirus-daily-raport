package io.github.kacperfaber.reports

import java.time.LocalDate

interface IDateTimeWriter {
    fun writeDate(l: LocalDate): String
}