package io.github.kacperfaber.thymeleaf

import org.springframework.stereotype.Component
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context

@Component
class DefaultThymeleafProcessor(var engine: TemplateEngine) : ThymeleafProcessor {
    override fun processToHtml(thymeleafHtml: String, ctx: Context): String {
        return engine.process(thymeleafHtml, ctx)
    }
}