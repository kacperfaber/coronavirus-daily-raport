package io.github.kacperfaber.thymeleaf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.StringTemplateResolver

@Configuration
open class StringTemplateResolverBean {
    @Bean
    open fun stringTemplateResolver(): StringTemplateResolver {
        return StringTemplateResolver().apply {
            templateMode = TemplateMode.HTML
        }
    }
}