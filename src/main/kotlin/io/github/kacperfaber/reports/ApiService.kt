package io.github.kacperfaber.reports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

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
        val content = httpService.getContent(
            "https://koronawirus-api.herokuapp.com/api/covid19/from/${dateWriter.writeDate(from)}/to/${dateWriter.writeDate(to)}"
        )
        return reportsJsonReader.read(content)
    }

    fun getAllReports(): Array<Report> {
        val content = httpService.getContent("https://koronawirus-api.herokuapp.com/api/covid19/from/2020-03-01/to/${dateWriter.writeDate(LocalDateTime.now())}")
        return reportsJsonReader.read(content)
    }

    fun getReport(date: LocalDateTime): Report? {
        val r = httpService.get("https://koronawirus-api.herokuapp.com/api/covid19/from/${dateWriter.writeDate(date)}/to/${dateWriter.writeDate(date.plusDays(1))}")
        if (r.isSuccessful) {
            val content = r.body!!.string()
            val reports = reportsJsonReader.read(content)
            return reports.getOrElse(0) { null }
        }
        return null
    }
}