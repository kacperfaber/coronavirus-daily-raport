package io.github.kacperfaber.thymeleaf

import org.springframework.context.annotation.*
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.*

@Configuration
open class TemplateResolverBean {
    @Bean
    open fun templateResolver(): ITemplateResolver {
        return ClassLoaderTemplateResolver().apply {
            prefix = "th-templates/"
            suffix = ".html"
            templateMode = TemplateMode.HTML
            characterEncoding = "UTF-8"
        }
    }
}