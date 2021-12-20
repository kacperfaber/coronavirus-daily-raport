package io.github.kacperfaber.reports

import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class VaccinationReportsDeserializer(var gson: Gson) : JsonReader<Array<VaccinationReport>> {
    override fun read(str: String): Array<VaccinationReport> {
        return gson.fromJson(str, Array<VaccinationReport>::class.java)
    }
}