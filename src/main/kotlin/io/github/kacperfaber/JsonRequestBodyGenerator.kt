package io.github.kacperfaber

import okhttp3.RequestBody

interface JsonRequestBodyGenerator {
    fun generate(json: String): RequestBody
}