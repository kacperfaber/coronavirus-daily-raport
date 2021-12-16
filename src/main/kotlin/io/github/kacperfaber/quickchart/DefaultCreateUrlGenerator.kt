package io.github.kacperfaber.quickchart

import org.springframework.stereotype.Component

@Component
class DefaultCreateUrlGenerator : CreateUrlGenerator{
    override fun generate(): String = "https://quickchart.io/chart/create"
}