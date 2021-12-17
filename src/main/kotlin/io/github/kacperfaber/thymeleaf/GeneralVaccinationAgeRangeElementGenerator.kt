package io.github.kacperfaber.thymeleaf

import io.github.kacperfaber.html.ElementGenerator
import io.github.kacperfaber.html.EmptyHtmlElement
import io.github.kacperfaber.quickchart.ChartService
import io.github.kacperfaber.reports.AgeRange
import io.github.kacperfaber.reports.Report
import io.github.kacperfaber.reports.ReportStorage
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class GeneralVaccinationAgeRangeElementGenerator(var chartService: ChartService, var reportStorage: ReportStorage) : ElementGenerator {
    override fun generate(todayReport: Report): EmptyHtmlElement {
        val yesterday = LocalDate.now().minusDays(1)
        val ageTypes = reportStorage.getVaccinationReport(yesterday)!!.general.ageTypes
        val filtered = ageTypes.filter { x -> x.ageType != AgeRange.Unknown }
        val url = chartService.createDoughnut(filtered.map { x -> x.ageType.name }, ageTypes.map { x -> x.vaccinations })
        return SignedImageElement("Ogólna liczba szczepień w poszczególnych grupach wiekowych [${yesterday.format(
            DateTimeFormatter.ofPattern("dd-MM-yyyy"))}r.]", url!!.url, 1200, 1200)
    }
}