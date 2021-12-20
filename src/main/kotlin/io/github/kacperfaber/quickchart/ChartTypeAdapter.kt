package io.github.kacperfaber.quickchart

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
class ChartTypeAdapter : JsonSerializer<ChartType> {
    override fun serialize(p0: ChartType?, p1: Type?, p2: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(p0!!.name.lowercase())
    }
}