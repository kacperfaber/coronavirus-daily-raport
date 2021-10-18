package io.github.kacperfaber.reports

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.springframework.stereotype.Component
import java.io.StringReader
import java.lang.reflect.Type
import java.text.DateFormat
import java.time.LocalDateTime

@Component
class ReportJsonReader(var gson: Gson) : JsonReader<Report> {
    override fun read(str: String): Report {
        return gson.fromJson(StringReader(str), Report::class.java)
    }
}