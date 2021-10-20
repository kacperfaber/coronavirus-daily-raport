package io.github.kacperfaber.reports

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class ApiService(val reportJsonReader: JsonReader<Report>, var httpService: HttpService, var dateWriter: IDateTimeWriter, var reportsJsonReader: JsonReader<Array<Report>>) {
    fun getReport(): Report? {
        val response = httpService.get("https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/daily")
        if (response.isSuccessful) {
            return reportJsonReader.read(response.body!!.string())
        }
        return null
    }

    fun getReports(from: LocalDateTime, to: LocalDateTime): Array<Report> {
        val content = httpService.getContent(
            "https://koronawirus-api.herokuapp.com/api/covid19/from/${dateWriter.writeDate(from)}/to/${dateWriter.writeDate(to)}"
        )
        return reportsJsonReader.read(content)
    }

    fun getAllReports(): Array<Report> {
        val content = httpService.getContent("https://koronawirus-api.herokuapp.com/api/covid19/from/2020-03-01/to/${dateWriter.writeDate(LocalDateTime.now())}")
        return reportsJsonReader.read(content)
    }

    fun getReport(date: LocalDate): Report? {
        val r = httpService.get("https://koronawirus-api.herokuapp.com/api/covid19/from/${dateWriter.writeDate(date)}/to/${dateWriter.writeDate(date.plusDays(1))}")
        if (r.isSuccessful) {
            val content = r.body!!.string()
            val reports = reportsJsonReader.read(content)
            return reports.find { x -> x.reportDate == date}
        }
        return null
    }
}