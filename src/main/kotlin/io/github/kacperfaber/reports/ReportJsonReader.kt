package io.github.kacperfaber.reports

import com.google.gson.Gson
import org.springframework.stereotype.Component
import java.io.StringReader

@Component
class ReportJsonReader(var gson: Gson) : JsonReader<CovidReport> {
    override fun read(str: String): CovidReport {
        return gson.fromJson(StringReader(str), CovidReport::class.java)
    }
}