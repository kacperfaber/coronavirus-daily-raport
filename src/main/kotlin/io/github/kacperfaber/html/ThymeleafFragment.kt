package io.github.kacperfaber.html

class ThymeleafFragment(var fragmentDoc: String, var fragment: String, var params: HashMap<String, Any>) : EmptyHtmlElement() {
    override fun render(): String = "<div th:insert=\"$fragmentDoc :: ${fragment}\"></div>"

    fun renderFragmentInvocation() = "${fragment}()"

    fun renderParameters() {
        val b = StringBuilder()
        for (key in params.keys) {
            b.append("${key}='${params[key]}'")
        }
    }
}