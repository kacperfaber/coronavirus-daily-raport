package io.github.kacperfaber.api

import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Component
open class SubscriptionService(var repo: SubscriptionRepository, var codeGenerator: CodeGenerator) {
    fun subscribe(email: String): SubscribeResult {
        if (repo.getByEmail(email) == null) {
            val s = Subscription()
            s.email = email
            s.createdAt = Timestamp.valueOf(LocalDateTime.now())
            s.confirmationCode = codeGenerator.generate()
            repo.save(s)
            return SubscribeResult.Ok
        }
        return SubscribeResult.AlreadyExist
    }

    fun confirm(email: String, code: String): ConfirmResult {
        val subscription = repo.getNotConfirmedByEmail(email)
        if (subscription!!.confirmationCode!! == code) {
            subscription.confirmedAt = Timestamp.valueOf(LocalDateTime.now())
            repo.saveOrUpdate(subscription)
            return ConfirmResult.Ok
        }
        return ConfirmResult.NotFound
    }

    fun cancel(email: String, cancelCode: String): Boolean {
        val byEmail = repo.getByEmailAndCancelCode(email, cancelCode)
        if (byEmail != null) {
            byEmail.canceledAt = Timestamp.valueOf(LocalDateTime.now())
            repo.saveOrUpdate(byEmail)
            return true
        }
        return false
    }
}