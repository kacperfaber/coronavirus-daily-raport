package io.github.kacperfaber.history

import org.hibernate.SessionFactory
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
open class HistoryRepository(var factory: SessionFactory) {
    private fun resultListByDate(date: LocalDate): MutableList<HistoryLog> {
        val sess = factory.openSession()
        sess.beginTransaction()
        val resultList = sess.createQuery("FROM HistoryLog HL WHERE HL.date = :d", HistoryLog::class.java)
            .setProperties(HashMap<String, Any>().apply { put("d", date) }).resultList
        sess.close()
        return resultList
    }

    open fun getLogs(date: LocalDate): List<HistoryLog> {
        return resultListByDate(date)
    }

    open fun getLog(date: LocalDate): HistoryLog? {
        return resultListByDate(date).getOrNull(0)
    }

    open fun put(log: HistoryLog): HistoryLog {
        val sess = factory.openSession()
        sess.beginTransaction()
        val serializable = sess.save(log)
        sess.close()
        return log.apply { id = serializable as Int ?: throw Exception() }
    }
}