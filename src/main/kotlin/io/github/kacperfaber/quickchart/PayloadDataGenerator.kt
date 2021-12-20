package io.github.kacperfaber.quickchart

interface PayloadDataGenerator {
    fun generate(labels: List<String>, dataSets: List<DataSet>): PayloadData
}