package io.github.kacperfaber.api.mvctests

import io.github.kacperfaber.api.SubscriptionService
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
@AutoConfigureWebMvc
class ApiController_cancel {
    @MockBean
    lateinit var service: SubscriptionService
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun doesntThrowWhenServiceReturnedTrue() {
        `when`(service.cancel(anyString(), anyString())).thenReturn(true)
        mvc.perform(get("subscribe/x/cancel/y"))
    }

    @Test
    fun doesntThrowWhenServiceReturnedFalse() {
        `when`(service.cancel(anyString(), anyString())).thenReturn(false)
        mvc.perform(get("subscribe/x/cancel/y"))
    }
}