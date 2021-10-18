package io.github.kacperfaber.reports

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.stereotype.Component
import java.text.DateFormat

@Component
class ReportsJsonReader : JsonReader<Array<Report>> {
    var gson: Gson = GsonBuilder().setDateFormat(DateFormat.FULL).create()

    override fun read(str: String): Array<Report> {
        return gson.fromJson(str, Array<Report>::class.java)
    }
}