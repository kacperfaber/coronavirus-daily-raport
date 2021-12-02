package io.github.kacperfaber.html

open class HtmlElement(var tag: String, var body: String) : Element(0) {
    fun render(): String {
        return "<${tag}>${body}</${tag}>"
    }
}