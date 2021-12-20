package io.github.kacperfaber

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import org.springframework.stereotype.Component

@Component
class DefaultJsonRequestBodyGenerator : JsonRequestBodyGenerator {
    override fun generate(json: String): RequestBody {
        val mediaType = "application/json".toMediaType()
        return RequestBody.Companion.create(mediaType, json)
    }
}