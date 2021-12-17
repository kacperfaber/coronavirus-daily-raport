package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class ChartService(var api: ChartApi, var payloadGenerator: PayloadGenerator) {
    fun createDoughnut(map: HashMap<String, Any>): ChartUrl? {
        val payload = payloadGenerator.generate(ChartType.Doughnut, map.map { x -> x.key }, listOf(map.map { x -> x.value }))
        return api.create(payload).toNullableUrl()
    }

    fun createDoughnut(labels: List<String>, dataSet: List<Any>): ChartUrl?{
        val payload = payloadGenerator.generate(ChartType.Doughnut, labels, listOf(dataSet))
        return api.create(payload).toNullableUrl()
    }

    fun create(chartType: ChartType, labels: List<String>, dataSets: List<List<Any>>): ChartUrl? {
        val payload = payloadGenerator.generate(chartType, labels, dataSets)
        return api.create(payload).toNullableUrl()
    }
}