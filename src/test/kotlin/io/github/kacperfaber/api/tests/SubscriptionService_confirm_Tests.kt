package io.github.kacperfaber.api.tests

import io.github.kacperfaber.api.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*
import java.util.*
import kotlin.test.assertEquals

@DisplayName("SubscriptionService.confirm(String, String)")
@ExtendWith(MockitoExtension::class)
class SubscriptionService_confirm_Tests {
    @Mock
    lateinit var repo: SubscriptionRepository

    @Mock
    lateinit var codeGenerator: CodeGenerator

    fun exec(email: String, code: String) = SubscriptionService(repo, codeGenerator).confirm(email, code)

    @Test
    fun doesNotThrow() {
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(null)
        assertDoesNotThrow { exec("kacper@gmail.com", "45555") }
    }

    @Test
    fun NotFoundIfRepoGetNotConfirmedByEmailReturnedNull() {
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(null)
        assertEquals(ConfirmResult.NotFound, exec("kacper@gmail.com", "5555"))
    }

    @Test
    fun repoGetNotConfirmedByEmailCalledOnce() {
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(null)
        exec("kacper@gmail.com", "5555")
        verify(repo, times(1)).getNotConfirmedByEmail(any())
    }

    @Test
    fun NotFoundIfRepoReturnedObjectWithOtherThanGivenConfirmationCode() {
        val code = UUID.randomUUID().toString()
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(Subscription().apply { confirmationCode=code })
        val res = exec("kacper@gmail.com", "xd")
        assertEquals(ConfirmResult.NotFound, res)
    }

    @Test
    fun repoSaveOrUpdateCalledIfSubscriptionReturnedInstanceWithMatchingCode() {
        val code = UUID.randomUUID().toString()
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(Subscription().apply { confirmationCode=code })
        `when`(repo.saveOrUpdate(any())).then {  }
        exec("kacper@gmail.com", code)
        verify(repo, times(1)).saveOrUpdate(any())
    }

    @Test
    fun repoSaveOrUpdateParameterEqualsToReturnedByRepo() {
        val subscription = Subscription().apply { confirmationCode = "xd"}
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(subscription)
        `when`(repo.saveOrUpdate(any())).then {  }
        exec("kacper@gmail.com", "xd")
        verify(repo).saveOrUpdate(eq(subscription))
    }

    @Test
    fun OkIfRepoReturnedNotNullAndCodeMatchedToGiven() {
        val subscription = Subscription().apply { confirmationCode = "xd"}
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(subscription)
        `when`(repo.saveOrUpdate(any())).then {  }
        assertEquals(ConfirmResult.Ok, exec("kacper@gmail.com", "xd"))
    }

    @Test
    fun repoSaveOrUpdateCalledOnceIfRepoReturnedNotNullWithGoodCode() {
        val code = "xd"
        val subscription = Subscription().apply { confirmationCode = code }
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(subscription)
        `when`(repo.saveOrUpdate(any())).then {  }
        exec("kacper@gmail.com", code)
        verify(repo, times(1)).saveOrUpdate(any())
    }

    @Test
    fun repoSaveOrUpdateCalledNeverIfRepoReturnedNull() {
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(null)
        exec("kacper@gmail.com", "555")
        verify(repo, never()).saveOrUpdate(any())
    }

    @Test
    fun repoSaveOrUpdateCalledNeverIfRepoReturnedNotNullWithBadCode() {
        val subscription = Subscription().apply { confirmationCode = "xd" }
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(subscription)
        exec("kacper@gmail.com", "555")
        verify(repo, never()).saveOrUpdate(any())
    }

    @Test
    fun repoGetNotConfirmedByEmailGetsGivenEmail() {
        val email = UUID.randomUUID().toString()
        `when`(repo.getNotConfirmedByEmail(any())).thenReturn(null)
        exec(email, "code")
        verify(repo).getNotConfirmedByEmail(eq(email))
    }
}