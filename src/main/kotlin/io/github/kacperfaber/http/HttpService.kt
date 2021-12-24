package io.github.kacperfaber.http

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.springframework.stereotype.Service

@Service
open class HttpService {
    var client: OkHttpClient = OkHttpClient()

    open fun getContent(url: String): String {
        val client = OkHttpClient()
        val request = Request.Builder().url(url)
            .get()
            .build()
        val call = client.newCall(request)
        val response = call.execute()
        return response.body!!.string()
    }

    open fun get(url: String): Response {
        val request = Request.Builder().url(url).get().build()
        return client.newCall(request).execute()
    }

    open fun postJson(url: String, json: String): Response {
        val requestBody = RequestBody.Companion.create("application/json".toMediaType(), json)
        val client = OkHttpClient()
        val request = Request.Builder().url(url)
            .post(requestBody)
            .build()
        val call = client.newCall(request)
        val response = call.execute()
        return response
    }

    open fun post(url: String, body: RequestBody): Response {
        val client = OkHttpClient()
        val req = Request.Builder().url(url).post(body).build()
        val call = client.newCall(req)
        return call.execute()
    }
}
