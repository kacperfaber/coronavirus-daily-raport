package io.github.kacperfaber.raports

import com.google.gson.Gson
import org.springframework.stereotype.Component
import java.io.StringReader

@Component
class ReportJsonReader : JsonReader<Report> {
    override fun read(str: String): Report {
        return Gson().fromJson(StringReader(str), Report::class.java)
    }
}