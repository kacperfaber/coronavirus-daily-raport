package io.github.kacperfaber.reports

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.stereotype.Component
import java.io.StringReader
import java.text.DateFormat

@Component
class ReportJsonReader : JsonReader<Report> {
    var gson: Gson = GsonBuilder().setDateFormat(DateFormat.FULL).create()

    override fun read(str: String): Report {
        return gson.fromJson(StringReader(str), Report::class.java)
    }
}