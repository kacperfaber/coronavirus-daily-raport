package io.github.kacperfaber.html

interface ElementsSorter {
    fun sort(elements: List<EmptyHtmlElement>): List<EmptyHtmlElement>
}