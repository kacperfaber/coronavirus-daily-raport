package io.github.kacperfaber.emails

import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class DefaultSubjectGenerator : SubjectGenerator{
    override fun generate(date: LocalDate, newInfections: Int): String {
        return "${newInfections} nowych potwierdzonych przypadków koronawirusa. [Raport ${date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}r.]"
    }
}