package io.github.kacperfaber.api.tests

import io.github.kacperfaber.api.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.argThat
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import java.util.*
import kotlin.test.assertEquals

@DisplayName("SubscriptionService.subscribe(String)")
class SubscriptionService_subscribe_Tests {
    var repo = mock(SubscriptionRepository::class.java)
    var codeGenerator = mock(CodeGenerator::class.java)

    fun exec(email: String) = SubscriptionService(repo, codeGenerator).subscribe(email)

    @Test
    fun doesNotThrow() {
        `when`(repo.getByEmail(any())).thenReturn(null)
        `when`(repo.save(any())).thenReturn(0)
        `when`(codeGenerator.generate(any())).thenReturn("code")
        assertDoesNotThrow { exec("kacper@gmail.com") }
    }

    @Test
    fun AlreadyExistsWhenRepoGetByEmailReturnedNull() {
        `when`(repo.getByEmail(any())).thenReturn(Subscription())
        assertEquals(SubscribeResult.AlreadyExist, exec("kacper@gmail.com"))
    }

    @Test
    fun OkWhenRepoGetByEmailReturnedNotNull() {
        `when`(repo.getByEmail(any())).thenReturn(null)
        `when`(repo.save(any())).thenReturn(0)
        `when`(codeGenerator.generate(any())).thenReturn("code")
        assertEquals(SubscribeResult.Ok, exec("kacper@gmail.com"))
    }

    @Test
    fun repoSaveMethodGetsNotNull() {
        `when`(repo.getByEmail(any())).thenReturn(null)
        `when`(repo.save(any())).thenReturn(0)
        `when`(codeGenerator.generate(any())).thenReturn("code")
        exec("kacper@gmail.com")
        verify(repo).save(any())
    }
    
    @Test
    fun repoSaveGetsSubscriptionWithCodeGivenByCodeGenerator() {
        val code = UUID.randomUUID().toString()
        `when`(repo.getByEmail(any())).thenReturn(null)
        `when`(repo.save(any())).thenReturn(0)
        `when`(codeGenerator.generate(any())).thenReturn(code)
        exec("kacper@gmail.com")
        verify(repo).save(argThat { x -> x.confirmationCode.equals(code) })
    }
    
    @Test
    fun codeGeneratorCalledWhenRepoGetByEmailReturnedNotNull() {
        `when`(repo.getByEmail(any())).thenReturn(Subscription())
        `when`(repo.save(any())).thenReturn(0)
        `when`(codeGenerator.generate(any())).thenReturn("abc")
        exec("kacper@gmail.com")
        verify(codeGenerator, never()).generate(any())
    }

    @Test
    fun repoSaveCalledWhenRepoGetByEmailReturnedNotNull() {
        `when`(repo.getByEmail(any())).thenReturn(Subscription())
        `when`(repo.save(any())).thenReturn(0)
        `when`(codeGenerator.generate(any())).thenReturn("abc")
        exec("kacper@gmail.com")
        verify(repo, never()).save(any())
    }
}