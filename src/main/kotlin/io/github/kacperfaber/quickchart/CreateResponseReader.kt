package io.github.kacperfaber.quickchart

import com.google.gson.Gson
import io.github.kacperfaber.reports.JsonReader
import org.springframework.stereotype.Component

@Component
class CreateResponseReader(val gson: Gson) : JsonReader<CreateResponse> {
    override fun read(str: String): CreateResponse {
        return gson.fromJson(str, CreateResponse::class.java)
    }
}