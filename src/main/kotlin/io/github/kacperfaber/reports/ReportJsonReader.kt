package io.github.kacperfaber.reports

import com.google.gson.Gson
import org.springframework.stereotype.Component
import java.io.StringReader

@Component
class ReportJsonReader(var gson: Gson) : JsonReader<Report> {
    override fun read(str: String): Report {
        return gson.fromJson(StringReader(str), Report::class.java)
    }
}