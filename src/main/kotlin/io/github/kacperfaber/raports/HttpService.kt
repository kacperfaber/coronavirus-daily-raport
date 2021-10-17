package io.github.kacperfaber.raports

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service

@Service
class HttpService {
    var client: OkHttpClient = OkHttpClient()

    fun getContent(url: String): String {
        val client = OkHttpClient()
        val request = Request.Builder().url(url)
                .get()
                .build()
        val call = client.newCall(request)
        val response = call.execute()
        return response.body!!.string()
    }
}