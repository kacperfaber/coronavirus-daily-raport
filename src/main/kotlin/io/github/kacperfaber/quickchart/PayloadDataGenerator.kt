package io.github.kacperfaber.quickchart

interface PayloadDataGenerator {
    fun generate(labels: List<String>, dataSet: List<List<Any>>): PayloadData
}