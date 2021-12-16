package io.github.kacperfaber.reports

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
class AgeRangeAdapter : JsonDeserializer<AgeRange> {
    override fun deserialize(p0: JsonElement?, p1: Type?, p2: JsonDeserializationContext?): AgeRange{
        return AgeRange.valueOf(p0!!.asString)
    }
}