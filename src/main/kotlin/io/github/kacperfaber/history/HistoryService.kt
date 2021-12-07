package io.github.kacperfaber.history

import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Component
class HistoryService(var repo: HistoryRepository) {
    fun getLog(date: LocalDate): HistoryLog? {
        return repo.getLog(date)
    }

    fun createLog(date: LocalDate): HistoryLog {
        val log = HistoryLog()
        log.date = date
        log.createdAt = Timestamp.valueOf(LocalDateTime.now())
        return repo.put(log)
    }
}