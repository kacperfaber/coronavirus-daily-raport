package io.github.kacperfaber.thymeleaf

import org.thymeleaf.context.Context

interface ThymeleafProcessor {
    fun processToHtml(thymeleafHtml: String, ctx: Context): String
}