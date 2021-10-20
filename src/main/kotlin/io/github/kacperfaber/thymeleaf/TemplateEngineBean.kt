package io.github.kacperfaber.thymeleaf

import org.springframework.context.annotation.*
import org.thymeleaf.TemplateEngine
import org.thymeleaf.templateresolver.ITemplateResolver

@Configuration
open class TemplateEngineBean {
    @Bean
    open fun templateEngine(resolverBean: ITemplateResolver): TemplateEngine {
        val engine = TemplateEngine()
        engine.setTemplateResolver(resolverBean)
        return engine
    }
}