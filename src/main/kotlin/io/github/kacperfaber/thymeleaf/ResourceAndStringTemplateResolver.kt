package io.github.kacperfaber.thymeleaf

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.thymeleaf.IEngineConfiguration
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templateresolver.ITemplateResolver
import org.thymeleaf.templateresolver.StringTemplateResolver
import org.thymeleaf.templateresolver.TemplateResolution

@Component
@Primary
class ResourceAndStringTemplateResolver(
    var templateResolver: ClassLoaderTemplateResolver,
    var stringResolver: StringTemplateResolver
) : ITemplateResolver {
    override fun getName(): String = javaClass.name

    override fun getOrder(): Int = 0

    override fun resolveTemplate(
        p0: IEngineConfiguration?,
        p1: String?,
        p2: String?,
        p3: MutableMap<String, Any>?
    ): TemplateResolution {
        return if (!p2!!.contains("<")) templateResolver.resolveTemplate(p0, p1, p2, p3) else stringResolver.resolveTemplate(
            p0,
            p1,
            p2,
            p3
        )
    }
}