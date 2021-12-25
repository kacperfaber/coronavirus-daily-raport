package io.github.kacperfaber.api.tests

import io.github.kacperfaber.api.CodeGenerator
import io.github.kacperfaber.api.Subscription
import io.github.kacperfaber.api.SubscriptionRepository
import io.github.kacperfaber.api.SubscriptionService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("SubscriptionService.cancel(String, String)")
@ExtendWith(MockitoExtension::class)
class SubscriptionService_cancel_Tests {
    @Mock
    lateinit var repo: SubscriptionRepository

    @Mock
    lateinit var codeGenerator: CodeGenerator

    fun exec(email: String, cancelCode: String) = SubscriptionService(repo, codeGenerator).cancel(email, cancelCode)

    @Test
    fun doesNotThrow() {
        assertDoesNotThrow { exec("kacper@gmail.com", "xxx") }
    }

    @Test
    fun FalseIfRepoGetByEmailAndCancelCodeReturnedNull() {
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(null)
        assertFalse(exec("kacper@gmail.com", "xxx"))
    }

    @Test
    fun TrueIfRepoGetByEmailAndCancelCodeReturnedNotNull() {
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(Subscription())
        assertTrue(exec("kacper@gmail.com", "xxx"))
    }

    @Test
    fun repoGetByEmailAndCancelCodeCalledOnce() {
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(null)
        exec("kacper@gmail.com", "xxx")
        verify(repo, times(1)).getByEmailAndCancelCode(any(), any())
    }

    @Test
    fun repoGetByEmailAndCodeGetsExpectedEmail() {
        val email = "kacper@gmail.com"
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(null)
        exec(email, "xxx")
        verify(repo).getByEmailAndCancelCode(eq(email), any())
    }

    @Test
    fun repoGetByEmailAndCodeGetsExpectedCode() {
        val code = "code"
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(null)
        exec("kacper@gmail.com", code)
        verify(repo).getByEmailAndCancelCode(any(), eq(code))
    }

    @Test
    fun repoSaveOrUpdateCalledOnceIfGetByEmailReturnedNotNull() {
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(Subscription())
        exec("kacper@gmail.com", "xxx")
        verify(repo, times(1)).saveOrUpdate(any())
    }

    @Test
    fun repoSaveOrUpdateCalledNeverIfGetByEmailReturnedNull() {
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(null)
        exec("kacper@gmail.com", "xxx")
        verify(repo, never()).saveOrUpdate(any())
    }

    @Test
    fun repoSaveOrUpdateGetsSubscriptionEqualsToReturnedByGetByEmailAndCode() {
        val expected = Subscription().apply { id = 5 }
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(expected)
        exec("kacper@gmail.com", "xxx")
        verify(repo).saveOrUpdate(eq(expected))
    }

    @Test
    fun repoSaveOrUpdateGetsSubscriptionWithNotNullCanceledAt() {
        `when`(repo.getByEmailAndCancelCode(any(), any())).thenReturn(Subscription())
        exec("kacper@gmail.com", "xxx")
        verify(repo).saveOrUpdate(argThat { x -> x.canceledAt != null })
    }
}