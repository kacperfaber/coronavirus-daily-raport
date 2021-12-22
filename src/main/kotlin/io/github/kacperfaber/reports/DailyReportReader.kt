package io.github.kacperfaber.reports

import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class DailyReportReader(var gson: Gson) : JsonReader<DailyReport> {
    override fun read(str: String): DailyReport = gson.fromJson(str, DailyReport::class.java)
}