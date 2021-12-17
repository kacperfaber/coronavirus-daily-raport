package io.github.kacperfaber

import okhttp3.ResponseBody
import org.springframework.stereotype.Component

@Component
class DefaultResponseBodyStringReader : ResponseBodyStringReader {
    override fun read(responseBody: ResponseBody): String {
        return responseBody.string()
    }
}