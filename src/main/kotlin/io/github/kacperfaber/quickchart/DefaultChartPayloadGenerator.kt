package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class DefaultChartPayloadGenerator(var dataGenerator: PayloadDataGenerator) : ChartPayloadGenerator {
    override fun generate(type: ChartType, labels: List<String>, dataSets: List<DataSet>): ChartPayload {
        return ChartPayload(type, dataGenerator.generate(labels, dataSets))
    }
}