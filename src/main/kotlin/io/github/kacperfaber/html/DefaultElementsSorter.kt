package io.github.kacperfaber.html

import org.springframework.stereotype.Component

@Component
class DefaultElementsSorter : ElementsSorter {
    override fun sort(elements: List<HtmlElement>): List<HtmlElement> = elements.sortedBy { x -> x.weight }
}