package io.github.kacperfaber.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ApiController(var service: SubscriptionService) {
    @PutMapping("subscribe/{email}")
    fun subscribe(@PathVariable("email") email: String): ResponseEntity<Any> {
        val res = service.subscribe(email)
        if (res != SubscribeResult.Ok) {
            return ResponseEntity.badRequest().body(res.toString())
        }
        return ResponseEntity.status(201).body(res.toString())
    }

    @PostMapping("subscribe/{email}/code={code}")
    fun confirm(@PathVariable("email") email: String, @PathVariable("code") code: String): ResponseEntity<Any> {
        val res = service.confirm(email, code)
        if (res != ConfirmResult.Ok) {
            return ResponseEntity.badRequest().body(res.toString())
        }
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("subscription/{email}/cancel/{cancelCode}")
    fun cancel(@PathVariable("email") email: String, @PathVariable("cancelCode") cancelCode: String): ResponseEntity<Any>{
        return if (service.cancel(email, cancelCode)) ResponseEntity.noContent().build() else ResponseEntity.badRequest().build()
    }
}