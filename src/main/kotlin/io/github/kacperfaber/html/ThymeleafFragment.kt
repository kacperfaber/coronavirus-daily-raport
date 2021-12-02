package io.github.kacperfaber.html

class ThymeleafFragment(var fragmentDoc: String, var fragment: String) : EmptyHtmlElement() {
    override fun render(): String = "<div th:insert=\"$fragmentDoc :: ${fragment}\"></div>"
}