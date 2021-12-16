package io.github.kacperfaber.quickchart

import io.github.kacperfaber.reports.HttpService
import org.springframework.stereotype.Component

@Component
class DefaultCreateRequestSender(var urlGenerator: CreateUrlGenerator, var httpService: HttpService, var payloadSerializer: PayloadJsonWriter) : CreateRequestSender {
    override fun send(payload: Payload): CreateResponse {
        val url = urlGenerator.generate()
        val json = payloadSerializer.write(payload)
        val response = httpService.postJson(url, json)
        response

        // TODO: Finish it, and use at ChartApi class.
    }
}