package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.html.EmptyHtmlElement

class SignedImageElement(var title: String, var url: String, var width: Int, var height: Int) : EmptyHtmlElement() {
    override fun render(): String {
        return "<h3>${title}</h3><img src=\"${url}\" width=\"${width}\" height=\"${height}\"/>"
    }
}

