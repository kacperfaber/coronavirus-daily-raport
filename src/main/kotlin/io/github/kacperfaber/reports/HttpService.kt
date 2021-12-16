package io.github.kacperfaber.reports

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
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

    fun postJson(url: String, json: String): Response {
        val requestBody = RequestBody.Companion.create("application/json".toMediaType(), json)
        val client = OkHttpClient()
        val request = Request.Builder().url(url)
            .post(requestBody)
            .build()
        val call = client.newCall(request)
        val response = call.execute()
        return response
    }
}
