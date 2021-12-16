package io.github.kacperfaber.reports

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ApiService(
    val reportJsonReader: JsonReader<Report>,
    var httpService: HttpService,
    var dateWriter: IDateTimeWriter,
    var reportsJsonReader: JsonReader<Array<Report>>,
    var vaccinationReportsDeserializer: JsonReader<Array<VaccinationReport>>
) {
    fun getReport(): Report? {
        val response = httpService.get("https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/daily")
        if (response.isSuccessful) {
            return reportJsonReader.read(response.body!!.string())
        }
        return null
    }

    fun getVaccinationReports(from: LocalDate, to: LocalDate): Array<VaccinationReport> {
        val content = httpService.getContent(
            "https://koronawirus-api.herokuapp.com/api/vaccinations/from/${dateWriter.writeDate(from)}/to/${dateWriter.writeDate(to)}"
        )
        return vaccinationReportsDeserializer.read(content)
    }

    fun getAllVaccinationReports(): Array<VaccinationReport> {
        return getVaccinationReports(LocalDate.of(2019, 1, 1), LocalDate.now())
    }

    fun getReports(from: LocalDate, to: LocalDate): Array<Report> {
        val content = httpService.getContent(
            "https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/from/${dateWriter.writeDate(from)}/to/${
                dateWriter.writeDate(
                    to
                )
            }"
        )
        return reportsJsonReader.read(content)
    }

    fun getAllReports(): Array<Report> {
        val content = httpService.getContent(
            "https://koronawirus-api.herokuapp.com/api/covid19/from/${
                dateWriter.writeDate(
                    LocalDate.of(2019, 12, 1)
                )
            }/to/${dateWriter.writeDate(LocalDate.now())}"
        )
        return reportsJsonReader.read(content)
    }

    fun getReport(date: LocalDate): Report? {
        val r = httpService.get(
            "https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/from/${dateWriter.writeDate(date)}/to/${
                dateWriter.writeDate(date.plusDays(1))
            }"
        )
        if (r.isSuccessful) {
            val content = r.body!!.string()
            val reports = reportsJsonReader.read(content)
            return reports.find { x -> x.reportDate == date }
        }
        return null
    }
}