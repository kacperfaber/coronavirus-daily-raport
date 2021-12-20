package io.github.kacperfaber

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.github.kacperfaber.quickchart.ChartType
import io.github.kacperfaber.quickchart.ChartTypeAdapter
import io.github.kacperfaber.reports.AgeRange
import io.github.kacperfaber.reports.AgeRangeAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalDateTime

@Configuration
open class GsonBean(
    var adapter: LocalDateTimeAdapter,
    var localDateAdapter: LocalDateAdapter,
    var ageRangeAdapter: AgeRangeAdapter,
    var chartTypeAdapter: ChartTypeAdapter
) {
    @Bean
    open fun gson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(LocalDateTime::class.java, adapter)
            .registerTypeAdapter(LocalDate::class.java, localDateAdapter)
            .registerTypeAdapter(AgeRange::class.java, ageRangeAdapter)
            .registerTypeAdapter(ChartType::class.java, chartTypeAdapter)
            .create()
    }
}