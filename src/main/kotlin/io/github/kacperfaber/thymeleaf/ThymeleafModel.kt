package io.github.kacperfaber.thymeleaf

data class ThymeleafModel(
    val newCases: Int,
    val newDeaths: Int,
    val positiveTestsPercentage: String,
    val totalTests: Int,
    val positiveTests: Int
)