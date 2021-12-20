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

    fun createSingleLine(dataName: String, data: HashMap<String, Array<Number>>): ChartUrl? {
        val p = payloadGenerator.generate(ChartType.Line, data.map { x -> x.key }, data.map { x -> DataSet(x.value).apply { label = dataName } })
        return api.create(p).toNullableUrl()
    }

    fun createLines(x: List<String>, data: HashMap<String, Array<Number>>): ChartUrl? {
        val p = payloadGenerator.generate(ChartType.Line, x, data.map { y -> DataSet(y.value).apply { label = y.key }})
        return api.create(p).toNullableUrl()
    }
}