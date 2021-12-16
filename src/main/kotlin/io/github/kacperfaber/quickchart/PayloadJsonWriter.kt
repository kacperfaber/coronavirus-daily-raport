package io.github.kacperfaber.quickchart

import com.google.gson.Gson
import io.github.kacperfaber.JsonWriter
import org.springframework.stereotype.Component

@Component
class PayloadJsonWriter(var gson: Gson) : JsonWriter<Payload> {
    override fun write(t: Payload): String {
        return gson.toJson(t)
    }
}