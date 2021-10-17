package io.github.kacperfaber

import io.github.kacperfaber.reports.ApiService
import io.github.kacperfaber.reports.Report
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @Autowired
    lateinit var apiService: ApiService

    @GetMapping("get")
    fun get(): ResponseEntity<Report> {
        return ResponseEntity.ok(apiService.getReport())
    }
}