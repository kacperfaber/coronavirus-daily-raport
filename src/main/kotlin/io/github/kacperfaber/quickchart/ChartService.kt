package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class ChartService(var api: ChartApi, var payloadGenerator: PayloadGenerator) {
    fun createDoughnut(map: HashMap<String, Number>): ChartUrl? {
        val dataSets = map.map { x -> DataSet(arrayOf(x.value)) }
        val payload = payloadGenerator.generate(ChartType.Doughnut, map.map { x -> x.key }, dataSets)
        return api.create(payload).toNullableUrl()
    }

    fun createDoughnut(labels: List<String>, dataSet: List<Number>): ChartUrl?{

        val payload = payloadGenerator.generate(ChartType.Doughnut, labels, dataSet.map { x -> DataSet(arrayOf(x)) })
        return api.create(payload).toNullableUrl()
    }

    fun create(chartType: ChartType, labels: List<String>, dataSets: List<List<Number>>): ChartUrl? {
        val payload = payloadGenerator.generate(chartType, labels, dataSets.map { x -> DataSet(x.toTypedArray()) })
        return api.create(payload).toNullableUrl()
    }
}