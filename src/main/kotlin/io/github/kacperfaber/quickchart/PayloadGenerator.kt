package io.github.kacperfaber.quickchart

interface PayloadGenerator {
    fun generate(type: ChartType, labels: List<String>, dataSets: List<List<Any>>): Payload
}