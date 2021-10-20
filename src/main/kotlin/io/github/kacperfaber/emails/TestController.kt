package io.github.kacperfaber.emails

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context

@RestController
class TestController(var engine: TemplateEngine) {
    @GetMapping("t")
    fun t(): String {
        val ctx = Context()
        ctx.setVariable("id", 55)
        return engine.process("index", ctx)
    }
}