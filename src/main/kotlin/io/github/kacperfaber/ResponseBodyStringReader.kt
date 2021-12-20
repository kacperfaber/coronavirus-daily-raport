package io.github.kacperfaber

import okhttp3.ResponseBody

interface ResponseBodyStringReader {
    fun read(responseBody: ResponseBody): String
}