package io.github.kacperfaber.raports

import org.springframework.stereotype.Component

@Component
class ByteArrayToStringConverter : Converter <ByteArray, String>{
    override fun convert(t: ByteArray): String {
        return String(t)
    }
}