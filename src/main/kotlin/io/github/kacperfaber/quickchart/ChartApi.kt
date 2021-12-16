package io.github.kacperfaber.quickchart

import io.github.kacperfaber.reports.HttpService

class ChartApi(var payloadGenerator: ChartPayloadGenerator, var payloadSerializer: PayloadJsonWriter, var httpService: HttpService, var createUrlGenerator: CreateUrlGenerator){
    fun createDoughnut(data: HashMap<String, Number>): ChartId{
        val payload = payloadGenerator.generate(ChartType.Doughnut, data.map { x -> x.key}, listOf(data.map { x -> x.value }))
        val json = payloadSerializer.write(payload)
        val url = createUrlGenerator.generate()

    }
}