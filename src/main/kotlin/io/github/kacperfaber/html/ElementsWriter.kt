package io.github.kacperfaber.html

interface ElementsWriter {
    fun write(elements: List<HtmlElement>): String
}