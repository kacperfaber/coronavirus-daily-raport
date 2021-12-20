package io.github.kacperfaber

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.springframework.stereotype.Component
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Component
class LocalDateTimeAdapter : JsonDeserializer<LocalDateTime> {
    override fun deserialize(p0: JsonElement?, p1: Type?, p2: JsonDeserializationContext?): LocalDateTime {
        return LocalDateTime.of(
            LocalDate.parse(p0!!.asString!!.take(10), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            LocalTime.MIDNIGHT
        )
    }
}