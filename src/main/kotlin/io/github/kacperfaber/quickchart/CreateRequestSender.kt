package io.github.kacperfaber.quickchart

interface CreateRequestSender {
    fun send(payload: Payload): CreateResponse
}