package io.github.kacperfaber.reports

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
class AgeTypeAdapter : JsonDeserializer<AgeType> {
    override fun deserialize(p0: JsonElement?, p1: Type?, p2: JsonDeserializationContext?): AgeType {

    }
}