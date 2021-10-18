package io.github.kacperfaber.reports

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
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

    fun get(url: String): Response {
        val request = Request.Builder().url(url).get().build()
        return client.newCall(request).execute()
    }
}