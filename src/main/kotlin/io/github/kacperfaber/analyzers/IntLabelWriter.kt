package io.github.kacperfaber.analyzers

import org.springframework.stereotype.Component

@Component
class IntLabelWriter : ElementWriter<IntLabel>{
    override fun write(element: IntLabel): String {
        return "${element.name}: ${element.value}"
    }
}