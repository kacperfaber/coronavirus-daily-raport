package io.github.kacperfaber.emails

import java.time.LocalDate
import java.time.LocalDateTime

class StaticEmailContent(var html: String, var generatedAt: LocalDateTime, var reportDate: LocalDate)