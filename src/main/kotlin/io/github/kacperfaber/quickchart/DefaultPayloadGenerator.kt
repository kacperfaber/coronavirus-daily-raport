package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class DefaultPayloadGenerator(var chartPayloadGenerator: ChartPayloadGenerator) : PayloadGenerator {
    override fun generate(chartType: ChartType, labels: List<String>, dataSets: List<DataSet>): Payload {
        return Payload(chartPayloadGenerator.generate(chartType, labels, dataSets))
    }
}