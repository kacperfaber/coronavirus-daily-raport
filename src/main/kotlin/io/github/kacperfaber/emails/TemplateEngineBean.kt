package io.github.kacperfaber.emails

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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