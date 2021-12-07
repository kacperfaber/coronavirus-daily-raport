package io.github.kacperfaber.html

import org.springframework.stereotype.Component

@Component
class DefaultElementsSorter : ElementsSorter {
    override fun sort(elements: List<EmptyHtmlElement>): List<EmptyHtmlElement> = elements.sortedBy { x -> x.weight }
}