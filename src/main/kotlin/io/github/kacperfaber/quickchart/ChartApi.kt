package io.github.kacperfaber.quickchart

import io.github.kacperfaber.JsonRequestBodyGenerator
import io.github.kacperfaber.ResponseBodyStringReader
import io.github.kacperfaber.http.HttpService
import io.github.kacperfaber.reports.JsonReader
import org.springframework.stereotype.Component

@Component
class ChartApi(
    var http: HttpService,
    var createUrlGenerator: CreateUrlGenerator,
    var jsonRequestBodyGenerator: JsonRequestBodyGenerator,
    var payloadJsonWriter: PayloadJsonWriter,
    var bodyStringReader: ResponseBodyStringReader,
    var createReader: JsonReader<CreateResponse>
) {
    fun create(p: Payload): CreateResponse? {
        val url = createUrlGenerator.generate()
        val payloadJson = payloadJsonWriter.write(p)
        val requestBody = jsonRequestBodyGenerator.generate(payloadJson)
        val response = http.post(url, requestBody)
        if (response.isSuccessful && response.body != null) {
            val body = bodyStringReader.read(response.body!!)
            return createReader.read(body)
        }
        return null
    }
}