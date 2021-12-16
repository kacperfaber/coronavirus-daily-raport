package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class DefaultPayloadGenerator(var dataGenerator: PayloadDataGenerator) : PayloadGenerator {
    override fun generate(type: ChartType, labels: List<String>, dataSets: List<List<Any>>): Payload {
        return Payload(type, dataGenerator.generate(labels, dataSets))
    }
}