package io.github.kacperfaber.reports

import com.google.gson.*
import org.springframework.stereotype.Component

@Component
class ReportsJsonReader(var gson: Gson) : JsonReader<Array<CovidReport>> {
    override fun read(str: String): Array<CovidReport> {
        return gson.fromJson(str, Array<CovidReport>::class.java)
    }
}