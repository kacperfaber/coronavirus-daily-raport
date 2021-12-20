package io.github.kacperfaber.quickchart

interface ChartPayloadGenerator {
    fun generate(type: ChartType, labels: List<String>, dataSets: List<DataSet>): ChartPayload
}