package io.github.kacperfaber.reports

import org.springframework.stereotype.Component

@Component
class ByteArrayToStringConverter : Converter<ByteArray, String> {
    override fun convert(t: ByteArray): String {
        return String(t)
    }
}