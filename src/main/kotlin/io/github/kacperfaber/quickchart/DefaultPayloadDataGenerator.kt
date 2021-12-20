package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class DefaultPayloadDataGenerator : PayloadDataGenerator{
    override fun generate(labels: List<String>, dataSets: List<DataSet>): PayloadData {
        return PayloadData(labels, dataSets)
    }
}