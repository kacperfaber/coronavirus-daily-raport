package io.github.kacperfaber.quickchart

import com.google.gson.*
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
class ChartTypeAdapter : JsonSerializer<ChartType> {
    override fun serialize(p0: ChartType?, p1: Type?, p2: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(p0!!.name.lowercase())
    }
}