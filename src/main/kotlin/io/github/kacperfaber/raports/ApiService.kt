package io.github.kacperfaber.raports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApiService {
    @Autowired
    lateinit var reportJsonReader: JsonReader<Report>
    @Autowired
    lateinit var httpService: HttpService

    fun getReport(): Report {
        val content = httpService.getContent("https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/daily")
        return reportJsonReader.read(content)
    }
}