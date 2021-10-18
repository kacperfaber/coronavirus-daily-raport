package io.github.kacperfaber.reports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.ArrayList

@Service
class ApiService {
    @Autowired
    lateinit var reportJsonReader: JsonReader<Report>
    @Autowired
    lateinit var httpService: HttpService
    @Autowired
    lateinit var dateWriter: IDateTimeWriter
    @Autowired
    lateinit var reportsJsonReader: JsonReader<Array<Report>>

    fun getReport(): Report {
        val content = httpService.getContent("https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/daily")
        return reportJsonReader.read(content)
    }

    fun getReports(from: LocalDateTime, to: LocalDateTime): Array<Report> {
        val content = httpService.getContent("https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/from/${dateWriter.writeDate(from)}/to/${dateWriter.writeDate(to)}")
        return reportsJsonReader.read(content)
    }

    fun getReport(date: LocalDateTime): Report? {
        val response = httpService.get("https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/from/${dateWriter.writeDate(date)}/to/${dateWriter.writeDate(date.plusDays(1))}")
        if (response.isSuccessful) {
            val content = response.body!!.string()
            val reports = reportsJsonReader.read(content)
            return reports.getOrElse(0) { null }
        }
        return null
    }
}