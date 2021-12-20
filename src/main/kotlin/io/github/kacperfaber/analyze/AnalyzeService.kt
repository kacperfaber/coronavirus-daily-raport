package io.github.kacperfaber.analyze

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AnalyzeService {
    fun avgByMonth(data: HashMap<LocalDate, List<Int>>, anyDayOfSelectedMonth: LocalDate): Double {
        val monthData = data.filter { x -> x.key.year == anyDayOfSelectedMonth.year && x.key.month == anyDayOfSelectedMonth.month }
        val monthDataList = monthData.map { x -> x.value }
        return monthDataList.first().average()
    }

    fun avg(data: HashMap<LocalDate, List<Int>>, from: LocalDate, to: LocalDate): Double {
        val selectedData = data.filter { x -> x.key in from..to }
        val selectedDataValues = selectedData.map { x -> x.value }
        return selectedDataValues.first().average()
    }
}