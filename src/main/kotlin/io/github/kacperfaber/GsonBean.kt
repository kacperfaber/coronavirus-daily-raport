package io.github.kacperfaber

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
open class GsonBean(var adapter: LocalDateTimeAdapter) {
    @Bean
    open fun gson(): Gson {
        return GsonBuilder().registerTypeAdapter(LocalDateTime::class.java, adapter).create()
    }
}