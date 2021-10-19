package io.github.kacperfaber.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(var service: SubscriptionService) {
    @PutMapping("subscribe/{email}")
    fun subscribe(@PathVariable("email") email: String): ResponseEntity<Any> {
        val res = service.subscribe(email)
        if (res != SubscribeResult.Ok) {
            return ResponseEntity.badRequest().body(res.toString())
        }
        return ResponseEntity.noContent().build()
    }
}