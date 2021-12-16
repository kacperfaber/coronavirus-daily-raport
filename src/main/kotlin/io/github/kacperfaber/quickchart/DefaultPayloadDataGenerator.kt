package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class DefaultPayloadDataGenerator : PayloadDataGenerator{
    override fun generate(labels: List<String>, dataSet: List<List<Any>>): PayloadData {
        val dataSets = dataSet.map { list -> DataSet(list.toTypedArray()) }
        return PayloadData(labels, dataSets)
    }
}