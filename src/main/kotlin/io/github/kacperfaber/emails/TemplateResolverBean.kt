package io.github.kacperfaber.emails

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templateresolver.ITemplateResolver

@Configuration
open class TemplateResolverBean {
    @Bean
    open fun templateResolver(): ITemplateResolver {
        val r = ClassLoaderTemplateResolver()
        r.prefix = "th-templates/"
        r.suffix = ".html"
        r.templateMode = TemplateMode.HTML
        r.characterEncoding = "UTF-8"
        return r
    }
}