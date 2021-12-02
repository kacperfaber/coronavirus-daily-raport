package io.github.kacperfaber.html

open class HtmlElement(var tag: String, var body: String) : EmptyHtmlElement() {
    override fun render(): String {
        return "<${tag}>${body}</${tag}>"
    }
}