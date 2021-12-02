package io.github.kacperfaber.html

import org.springframework.stereotype.Component

@Component
class DefaultElementsWriter : ElementsWriter {
    override fun write(elements: List<HtmlElement>): String {
        return elements.joinToString { x -> x.render() }
    }

}