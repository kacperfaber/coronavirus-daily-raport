package io.github.kacperfaber.api

import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.LocalDateTime

@Component
class SubscriptionService(var repo: SubscriptionRepository) {
    fun subscribe(email: String): SubscribeResult {
        if (repo.getByEmail(email) == null) {
            val s = Subscription()
            s.email = email
            s.createdAt = Timestamp.valueOf(LocalDateTime.now())
            repo.save(s)
            return SubscribeResult.Ok
        }
        return SubscribeResult.AlreadyExist
    }
}