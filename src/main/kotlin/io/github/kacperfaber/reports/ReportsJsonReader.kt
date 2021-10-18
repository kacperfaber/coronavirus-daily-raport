package io.github.kacperfaber.reports

import com.google.gson.*
import org.springframework.stereotype.Component
import java.lang.reflect.Type
import java.text.DateFormat
import java.time.LocalDateTime

@Component
class ReportsJsonReader(var gson: Gson) : JsonReader<Array<Report>> {
    override fun read(str: String): Array<Report> {
        return gson.fromJson(str, Array<Report>::class.java)
    }
}