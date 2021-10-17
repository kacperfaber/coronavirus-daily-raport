package io.github.kacperfaber.raports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApiService {
    @Autowired
    lateinit var byteArrayConverter: Converter<ByteArray, String>
    @Autowired
    lateinit var reportJsonReader: JsonReader<Report>

    fun getReport(): Report {
        val response = khttp.get("https://koronawirus-api.herokuapp.com/api/covid-vaccinations-tests/daily")
        val contentString = byteArrayConverter.convert(response.content)
        return reportJsonReader.read(contentString)
    }
}