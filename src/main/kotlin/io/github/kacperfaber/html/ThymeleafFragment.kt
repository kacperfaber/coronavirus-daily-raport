package io.github.kacperfaber.html

open class ThymeleafFragment(var fragmentDoc: String, var fragment: String, var params: HashMap<String, Any>) : EmptyHtmlElement() {
    override fun render(): String = "<div th:insert=\"$fragmentDoc :: ${renderFragmentInvocation()}\"></div>"

    fun renderFragmentInvocation() = "${fragment}(${renderParameters()})"

    fun renderParameters(): String {
        val b = StringBuilder()
        for (key in params.keys) {
            b.append("${key}='${params[key]}'")
            if (params.keys.last() != key) {
                b.append(", ")
            }
        }
        return b.toString()
    }
}