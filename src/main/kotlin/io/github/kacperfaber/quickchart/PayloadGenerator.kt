package io.github.kacperfaber.quickchart

interface PayloadGenerator {
    fun generate(chartType: ChartType, labels: List<String>, dataSets: List<DataSet>): Payload
}