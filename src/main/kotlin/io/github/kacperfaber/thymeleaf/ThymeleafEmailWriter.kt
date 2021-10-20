package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.emails.EmailWriter
import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context

@Component
class ThymeleafEmailWriter(var reportStorage: ReportStorage, var engine: TemplateEngine) : EmailWriter {
    override fun write(report: Report): String {
        val positiveTests = ((report.today!!.tests!!.infections.toDouble() / report.today!!.tests!!.tests!!.positive)).toString().take(5)
        val infections = report.today!!.infections ?: throw NullPointerException()
        val tests = report.today!!.tests!!.tests ?: throw NullPointerException()
        val model = ThymeleafModel(infections.newInfections as Int, infections.newDeaths as Int, positiveTests, tests.all, tests.positive)
        val ctx = Context().apply { setVariable("model", model) }
        return engine.process("base-template", ctx)
    }
}