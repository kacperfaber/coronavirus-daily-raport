package io.github.kacperfaber.thymeleaf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.TemplateEngine
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templateresolver.StringTemplateResolver

@Configuration
open class TemplateEngineBean {
    @Bean
    open fun templateEngine(stringTemplateResolver: StringTemplateResolver, classLoaderTemplateResolver: ClassLoaderTemplateResolver, customTemplateResolver: ResourceAndStringTemplateResolver): TemplateEngine {
        val engine = TemplateEngine()
//        engine.addTemplateResolver(stringTemplateResolver)
//        engine.addTemplateResolver(classLoaderTemplateResolver)
        engine.addDialect(Java8TimeDialect())
        engine.addTemplateResolver(customTemplateResolver)
        return engine
    }
}