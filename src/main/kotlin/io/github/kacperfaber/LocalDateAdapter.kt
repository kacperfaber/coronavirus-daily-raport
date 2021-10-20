package io.github.kacperfaber

import com.google.gson.*
import org.springframework.stereotype.Component
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class LocalDateAdapter : JsonDeserializer<LocalDate> {
    override fun deserialize(p0: JsonElement?, p1: Type?, p2: JsonDeserializationContext?): LocalDate {
        return LocalDate.parse(p0!!.asString!!.take(10), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }
}