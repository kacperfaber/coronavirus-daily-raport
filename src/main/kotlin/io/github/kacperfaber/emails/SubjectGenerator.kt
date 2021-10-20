package io.github.kacperfaber.emails

import java.time.LocalDate

interface SubjectGenerator {
    fun generate(date: LocalDate, newInfections: Int): String
}